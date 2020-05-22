private long currentTime;
private long maxTimer = 3000;
private double fivePercent = .05;
private CountDownTimer myTimer = null; 

protected void onCreate(Bundle savedInstanceState) {
    // Some code...

    // Assign 3000 to currentTime
    currentTime = maxTimer;

    ball.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    if (myTimer != null) {
                        // Cancel timer
                        myTimer.cancel();
                        // Calculating 5 % from maxTimer
                        long a = (long) (maxTimer * fivePercent);
                        maxTimer -= a;
                        // Storing new maxTimer in currentTime     
                        currentTime = maxTimer;
                    }

                   myTimer = new CountDownTimer(currentTime, 1) {
                       @Override
                       public void onTick(long millisUntilFinished) {
                           countDownText.setText("Time: " + String.valueOf(millisUntilFinished));
                           currentTime = millisUntilFinished;
                       }

                       @Override
                       public void onFinish() {
                           Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                           GameActivity.this.startActivity(intent); 
                       }
                   }.start();

               changePos();
               scoreLabel.setText("Score: " + score++ + "");
            }
            return true;
        }
    });
}