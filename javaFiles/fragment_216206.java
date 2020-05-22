private final Object keyPressMonitor = new Object();

private boolean running = true;

private Runnable gameLoop = new Runnable() {
    @Override
    public void run() {
        try {
            synchronized (keyPressMonitor) {
                while (true) {
                    while (!running) {
                        keyPressMonitor.wait();
                    }
                    doSomething();
                }
            }
        } catch (InterruptedException e) {
            logger.log(Level.INFO,
                "Interrupted; cleaning up and exiting.", e);
        }
    }
};