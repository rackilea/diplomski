long duration = 12345;
long ticksInterval = 1000; // 1 second in millis

new CountDownTimer(duration, ticksInterval){
    public void onTick(long remaining) {
        // Do something each ticksInterval millis
    }

    public void onFinish() {
        // Do something after duration millis
    }
}.start();