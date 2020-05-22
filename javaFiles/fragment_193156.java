long duration = 5000 // 5 seconds
long tick = 100 // 0.1 seconds;

new CountDownTimer(duration, tick) {

     public void onTick(long millisUntilFinished) {
         mImageButton.setAlpha(millisUntilFinished / (float)duration)
     }

     public void onFinish() {
         mImageButton.setVisibility(View.GONE);
         mImageButton.setAlpha(1); // incase you want to show the button again
     }
}.start();