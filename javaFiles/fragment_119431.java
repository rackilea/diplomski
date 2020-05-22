new CountDownTimer(9000000, 5000) {

 public void onTick(long millisUntilFinished) {
       Random ramhole = new Random();
        int hole = ramhole.nextInt(8);

        Random ramletter = new Random();
        int letter = ramletter.nextInt(26);
        hView.setText("Hole = "+hole+"Letter = "+letter);
 }

 public void onFinish() {
   //Restart timer if you want.
 }
}.start();