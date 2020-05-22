new CountDownTimer(1000, 1000) {

     public void onTick(long millisUntilFinished) {
         mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
     }

     public void onFinish() {
         mTextField.setText("done!");
     }
  }.start();