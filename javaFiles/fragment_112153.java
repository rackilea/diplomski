package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class levelone extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.levelone);
        Button finishf1 = (Button) findViewById(R.id.finishf1);
        finishf1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectlevel.PlayerProgress.updateProgress(1);
                startActivity(new Intent(levelone.this, selectlevel.class));
            }
        });
    }
}