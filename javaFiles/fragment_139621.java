boolean isRunning = false;

private Runnable sendData = new Runnable() {
    public void run() {
        try {
            isRunning = true;
            superToast.show();
            screenOn();
            vibrate();
            mHandler.postDelayed(sendData, time);
        } catch (Exception e) {
            e.printStackTrace();
            isRunning = false;
        }
    }
};