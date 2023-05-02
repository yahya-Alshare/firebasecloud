package com.example.firebasecloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.authentication.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {

    //Yaseen
    val db = Firebase.firestore
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)



        binding.save.setOnClickListener {

            var name = binding.PersonID.text.toString()
            var id = binding.PersonName.text.toString()
            var age = binding.PersonAge.text.toString()
            val person = hashMapOf(
                "name" to name,
                "id" to id,
                "age" to age
            )
            db.collection("Persons")
                .add(person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(applicationContext,"${documentReference.id}", Toast.LENGTH_SHORT).show()

                }
                .addOnFailureListener { e ->
                    Toast.makeText(applicationContext,"$e", Toast.LENGTH_SHORT).show()


                }
        }

    }
}