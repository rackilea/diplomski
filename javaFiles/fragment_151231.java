class Facebook implements Runnable {

    private final Object monitor = new Object();

    public boolean running = false;

    public void startThread() {
        synchronized (monitor) {
            running = true;
            monitor.notifyAll();
        }
    }

    public void stopThread() {
        synchronized (monitor) {
            running = false;
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                synchronized (monitor) {
                    // Wait until somebody calls startThread()
                    while (!running) {
                        monitor.wait();
                    }
                }

                //HTTP Calls
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                break;
            }
        }
    }
}