new Handler(Looper.getMainLooper()).post(new Runnable() {           
    @Override
    public void run() {
        mCountDownTimer  = new CountDownTimer(cdTime, 1000) {
        /* handle the countdown notifications as you wish, for example like you did in your question */ 
        }.start();
    } 
});