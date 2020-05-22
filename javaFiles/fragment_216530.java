if(n == 1){
    if (state == true) {
        n=0;
        state=false;
        action();
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
               state=true;
            }
        }.start();
    }
}