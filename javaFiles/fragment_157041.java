button1.setEnabled(false);
new CountDownTimer(5000, 10) { //Set Timer for 5 seconds
        public void onTick(long millisUntilFinished) {
        }

        @Override
        public void onFinish() {
               button1.setEnabled(true);
        }
    }.start()