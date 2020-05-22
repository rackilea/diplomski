mCountDownTimer = new CountDownTimer(5000, 10) {
        public void onTick(long millisUntilFinished) {
           text.setText(""+String.format("%02d:%03d",
           TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)),
           TimeUnit.MILLISECONDS.toMillis(millisUntilFinished) - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished));           
           }

         @Override
         public void onFinish() {
            text.setText("Too slow.");
            gameover();  
         }
     };
 mCountDownTimer.start();