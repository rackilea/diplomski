public void run() {
    initiateCAN();
    try {
        while (!isInterrupted()) {
            Thread.sleep(60);
            mHandler.post(r);
        }
    } catch (InterruptedException e) {
    }
}