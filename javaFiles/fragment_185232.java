final Worker theWorker = new Worker(); // the object you show code for

new Thread(new Runnable() {
    public void run() {
        theWorker.doWork();
    }
}.start();

try {
    Thread.sleep(1000L);
} catch(InterruptedException ie) {}

theWorker.shutdown();