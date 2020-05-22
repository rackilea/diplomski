class RunnableDemo implements Runnable {
    private ThreadMonitor lock;
    private String threadName;
    private String otheThreadName;

    RunnableDemo(String name, ThreadMonitor lock, String otheThreadName) {
        this.threadName = name;
        this.lock = lock;
        this.otheThreadName = otheThreadName;
        System.out.println("Creating " + threadName);
    }

    public void run() {

        synchronized (lock) {
            try {

                for (int i = 1; i <= 5; i++) {
                    while (!lock.getRunningThread().equals(threadName)) {
                        lock.wait();
                    }
                    System.out.println("Running " + threadName);
                    System.out.println("Thread: " + threadName + ", " + i);
                    lock.setRunningThread(otheThreadName);
                    lock.notify();
                }
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " interrupted.");
            }
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);

        Thread t = new Thread(this, threadName);
        t.start();
    }

}

public class TestThread {

    public static void main(String args[]) {
        ThreadMonitor lock = new ThreadMonitor("Thread-1");
        RunnableDemo R1 = new RunnableDemo("Thread-1", lock, "Thread-2");
        R1.start();

        RunnableDemo R2 = new RunnableDemo("Thread-2", lock, "Thread-1");
        R2.start();
    }
}

class ThreadMonitor {
    private String runningThread;

    public ThreadMonitor(String runningThread) {
        this.runningThread = runningThread;
    }

    public String getRunningThread() {
        return runningThread;
    }

    public void setRunningThread(String threadName) {
        runningThread = threadName;
    }
}