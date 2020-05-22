private class Background implements Runnable {

    private long startTime;
    private long time;
    private boolean halfWarning;

    private Background(long startTime, long time) {
        this.startTime = startTime;
        this.time = time;
    }

    @Override
    public void run() {

        while (true) {
            long now = System.currentTimeMillis() / 1000;
            long elapsed = now - startTime;

            if (elapsed >= (time / 2) && !halfWarning) {
                message("\n Half of your time is gone! Only " + (time / 2) + " seconds remains!");
                halfWarning = true;
            }

            if (elapsed >= time) {
                message("\n Oops! Time is up - try again.");
                System.exit(0);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //ignore
            }
        }
    }
}