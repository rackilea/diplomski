package com.example.testproject;

    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.Menu;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;
    import android.widget.RelativeLayout;
    import android.widget.Toast;

    public class MainActivity extends Activity {

        RelativeLayout lyt;
        public static Button button;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            lyt = (RelativeLayout) findViewById(R.id.main);
            button = new Button(this);
            button.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "clicked the button",
                            Toast.LENGTH_SHORT).show();
                }
            });
            lyt.addView(button);
            Intent i = new Intent(MainActivity.this, ActivityB.class);
            startActivity(i);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

    }