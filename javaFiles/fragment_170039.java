new CountDownTimer(300000, 1000) {

     public void onTick(long millisUntilFinished) {
     long time = 300000- millisUntilFinished;

      if(time == 120000){
          // do whatever you want
      }

     }

     public void onFinish() {
         mTextField.setText("done!");
     }
  }.start();