public class AutoUpdater implements Runnable {
    public void run() {
        try {
            lock.lock();
            System.out.println("Thread is running...");
                // do something...
            }
        } finally {
            System.out.println("Thread ended.\n");
            lock.unlock();
        }
    }
}