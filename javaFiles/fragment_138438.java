MyRunnable implements Runnable {

    private volatile boolean isActive = true;

    public void run() {
       while(isActive && !Thread.currentThread().isInterrupted()) {
           ...
       }
    }

    public void stop() {
        isActive = false;
    }
}