private void startCountDown() {
    try {
        countdownElapsed = 0l;
        next_button.setEnabled(false);
        displayCountDown();
        mCountDownHandler.postDelayed(mCountDownRunnable, COUNT_DOWN_TICKS);
    }
    catch (Exception ex){
        Log.e(TAG, ex.getMessage());
    }
}

private Runnable mCountDownRunnable = new Runnable() {
    @Override
    public void run() {
        countdownElapsed = countdownElapsed + COUNT_DOWN_TICKS;

        if(countdownElapsed >= COUNT_DOWN_FINISH){
            releaseCountDownHandler();
            next_button.setEnabled(true);
        }
        else{
            mCountDownHandler.postDelayed(mCountDownRunnable, COUNT_DOWN_TICKS);
        }

        long secFull = countdownElapsed % 1000;
        if(secFull == 0){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    displayCountDown();
                }
            });
        }
    }
};

private void releaseCountDownHandler() {
    try {
        if(mCountDownRunnable != null) {
            mCountDownHandler.removeCallbacks(mCountDownRunnable);
        }
    }
    catch (Exception ex){
        Log.e(TAG, ex.getMessage());
    }
}


private void displayCountDown(){
    long t = (COUNT_DOWN_FINISH - countdownElapsed)/1000;
    String myTime = String.valueOf(t);
    timer.setText(myTime);
}