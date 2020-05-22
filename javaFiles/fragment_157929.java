public class MainActivity extends Activity {
    protected CountDownTimer cd;
    private Button lastPressedButton;
    private Button red;
    private Button blue;
    private TextView blueTimer;
    private TextView redTimer;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            blueTimer = (TextView) findViewById(R.id.blueTimer);  
            blue = (Button) findViewById(R.id.button1);

            redTimer = (TextView) findViewById(R.id.redTimer);  
            red = (Button) findViewById(R.id.button2);



            cd = new CountDownTimer(300000, 1000) {

                 public void onTick(long millisUntilFinished) {
                        DecimalFormat dfmin = new DecimalFormat("0");
                        DecimalFormat dfsec = new DecimalFormat("00");
                        double seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)%60;
                        double min = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
if (lastPressedButton == red){
                 redTimer.setText(String.valueOf(dfmin.format(min)) + ":" + String.valueOf(dfsec.format(seconds)));
}
else if (lastPressedButton == blue){
                 blueTimer.setText(String.valueOf(dfmin.format(min)) + ":" + String.valueOf(dfsec.format(seconds)));
}


                 }

                 public void onFinish() {
    if (lastPressedButton == red)
                     blueTimer.setText("5:00");
    else if (lastPressedButton == blue){
    //something else?
    }
                 }
              };

            blue.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
    lastPressedButton = blue;
                    if (blueTimer.getText().toString().contains("5:00")){
                        cd.start();

                    } else {
                        cd.cancel();
                        cd.onFinish();
                    }

                }
            });

            red.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
    lastPressedButton = red;
                    if (redTimer.getText().toString().contains("5:00")){
                        cd.start();
                    } else {
                        cd.cancel();
                        cd.onFinish();
                    }

                }
            });
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

    }