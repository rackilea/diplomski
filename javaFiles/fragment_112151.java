package com.example.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class selectlevel extends Activity {

    Button f1, f2, f1lock, f2lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.selectlevel);

        f1 = (Button) findViewById(R.id.f1);
        f1lock = (Button) findViewById(R.id.f1lock);
        f1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent level1 = new Intent();
                level1.setClassName("com.example.myapp", "com.example.myapp.levelone");
                startActivity(level1);
            }
        });

        f2 = (Button) findViewById(R.id.f2);
        f2lock = (Button) findViewById(R.id.f2lock);
        f2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent level2 = new Intent();
                level2.setClassName("com.example.myapp", "com.example.myapp.leveltwo");
                startActivity(level2);
            }
        });

        updateLevels();
    }

    static class PlayerProgress {
        // We set progress to static, so it would be alive, no matter what activity you're in.
        private static int progress = 0;

        /**
         * Update the player's progress.
         *
         * @param levelNumber: latest level number.
         */
        public static void updateProgress(int levelNumber) {
            progress = levelNumber;
        }

        /**
         * Get the player's progress.
         *
         * @return the latest level number.
         */
        public static int getPlayerProgress() {
            return progress;
        }
    }

    public void updateLevels() {
        int progress = PlayerProgress.getPlayerProgress();

        switch (progress) {
            case 0:
                f1.setVisibility(View.VISIBLE);
                f1lock.setVisibility(View.GONE);
                f2.setVisibility(View.GONE);
                f2lock.setVisibility(View.VISIBLE);
                break;

            default:
                f1.setVisibility(View.VISIBLE);
                f1lock.setVisibility(View.GONE);
                f2.setVisibility(View.VISIBLE);
                f2lock.setVisibility(View.GONE);
                break;
        }
    }
}