package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.File
import java.nio.file.Files.exists
import java.nio.file.Paths


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val JSON_FILE = "bookings.json"

        // One option to check if file exists (available from API 26)
        if (exists(Paths.get(JSON_FILE))) {
            //
        }

        // Another option to check if file exists (available from API 1)
        val file = File(JSON_FILE)
        if (file.exists()) {
            //
        }
    }
}