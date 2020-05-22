package com.example.owner.introductoryapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import android.view.View;


public class UserDataInputActivity extends AppCompatActivity
{
    String[] genderOptions = {"Male", "Female", "Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_input);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, genderOptions);
        //Find TextView control
        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.GenderPromptValue);
        //Set the number of characters the user must type before the drop down list is shown
        acTextView.setThreshold(1);
        //Set the adapter
        acTextView.setAdapter(adapter);
    }

    public void onGenericMenuClick(View v)
    {
        Intent intent = null;

        if(v.getId() == R.id.pasttests)
        {
            intent =  new Intent(this, PastDiagnosticResult.class);
        }
        else if (v.getId() == R.id.currenttest)
        {
            intent =  new Intent(this, CurrentDiagnosticResultActivity.class);
        }
        else if (v.getId() == R.id.myinfo)
        {
            intent =  new Intent(this, UserDataInputActivity.class);
        }
        else //if(v.getId() == R.id.gaitInfoButton)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(UserDataInputActivity.this);
                builder.setMessage(R.string.GaitInformationContent)
                        .setPositiveButton(R.string.acknowledge, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //GO BACK TO THE USER DATA INPUT PAGE - HOW?
                            }
                        });
                // Create the AlertDialog object and return it
                builder.create().show();
        }

        if (intent != null) {
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
}