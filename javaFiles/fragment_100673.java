package com.example.test;

import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
boolean firstTime = true;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.i("test", "onCreate");
    Button button = (Button)findViewById(R.id.button1);
    button.setOnClickListener(new OnClickListener(){

        @Override
    public void onClick(View arg0) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS); 
        startActivity(intent);
        }
    });
}

@Override
protected void onResume(){
    super.onResume();
    Log.i("test", "onResume");
    if (firstTime){
    Log.i("test", "it's the first time");
    firstTime = false;
    }

    else{
    Log.i("test", "it's not the first time");

    }

}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
}