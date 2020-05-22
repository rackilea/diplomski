public class Processor extends Thread {
    private stopped;

    public void run() {
        while (!isStopped()) {
            // do stuff
        }
    }

    public synchronized void stop() {
        stopped = true;
    }

    private synchronized boolean isStopped() {
        return stopped;
    }
}