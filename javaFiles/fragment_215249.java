private void startHandlerAndWait10Seconds(){
    Handler handler1 = new Handler();
    handler1.postDelayed(new Runnable() {

        public void run() {
            // Start Countdown timer after wait for 10 seconds
            startCountDown();

        }
    }, 10000);
}

private void startCountDown {
    final Handler handler2 = new Handler();
    handler2.post(new Runnable() {
        int seconds = 60;

        public void run() {
            seconds--;
            mhello.setText("" + seconds);
            if (seconds < 0) {
                // DO SOMETHING WHEN TIMES UP
                stopTimer = true;
            }
            if(stopTimer == false) {
                handler2.postDelayed(this, 1000);
            }

        }
    });
}