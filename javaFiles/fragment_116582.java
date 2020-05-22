package com.example.testproject;

    import android.app.Activity;
    import android.os.Bundle;
    import android.widget.Button;

    public class ActivityB extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity a = new MainActivity();
        Button button =  MainActivity.button;
        button.performClick();
    }
    }