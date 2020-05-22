new CountDownTimer(5000, 1000) { // 5000 = 5 sec

     public void onTick(long millisUntilFinished) {
     }

     public void onFinish() {
        image.setImageResource(R.drawable.image2);
     }
}.start();