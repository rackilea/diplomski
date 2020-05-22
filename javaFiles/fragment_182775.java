package com.example.eric.questiondialog_artifact;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class DialogActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setTheme(R.style.AppTheme_Dialog); // can either use R.style.AppTheme_Dialog or R.style.AppTheme as deined in styles.xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }
}