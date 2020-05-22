package com.demesaict203.fieldchecker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstttextEditText = (EditText) findViewById(R.id.firsttextEditText);
        EditText secondtextEditText = (EditText) findViewById(R.id.secondtextEditText);
        Button checkbtn = (Button) findViewById(R.id.checkBtn);
        checkbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String firstValue = firstttextEditText.getText().toString();
                String secondValue = secondtextEditText.getText().toString();
                if (firstValue.equals(secondValue)) {
                    Intent sameTextIntent = new Intent(getApplicationContext(), SameText.class);
                    startActivity(sameTextIntent);
                } else {
                    Intent notsameTextIntent = new Intent(getApplicationContext(), NotTheSame.class);
                    startActivity(notsameTextIntent);
                }

            }
        });
    }
}