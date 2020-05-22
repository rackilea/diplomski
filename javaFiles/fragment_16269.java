long maxCounter = 30000;
long diff = 1000;

    new CountDownTimer(maxCounter , diff ) {

        public void onTick(long millisUntilFinished) {
            long diff = maxCounter - millisUntilFinished;
            mTextField.setText("seconds completed: " +diff  / 1000);
           //here you can have your logic to set text to edittext
        }

        public void onFinish() {
            mTextField.setText("done!");
        }

    }.start();