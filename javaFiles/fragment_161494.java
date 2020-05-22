import java.util.concurrent.locks.ReentrantReadWriteLock;

public class FairLocking {

    public static final boolean FAIR = true;
    private static final int NUM_THREADS = 3;

    private static volatile int expectedIndex = 0;

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock.WriteLock lock = new ReentrantReadWriteLock(FAIR).writeLock();

        // we grab the lock to start to make sure the threads don't start until we're ready
        lock.lock();

        for (int i = 0; i < NUM_THREADS; i++) {
            new Thread(new ExampleRunnable(i, lock)).start();

            // a cheap way to make sure that runnable 0 requests the first lock
            // before runnable 1
            Thread.sleep(10);
        }

        // let the threads go
        lock.unlock();
    }

    private static class ExampleRunnable implements Runnable {
        private final int index;
        private final ReentrantReadWriteLock.WriteLock writeLock;

        public ExampleRunnable(int index, ReentrantReadWriteLock.WriteLock writeLock) {
            this.index = index;
            this.writeLock = writeLock;
        }

        public void run() {
            while(true) {
                writeLock.lock();
                try {
                    // this sleep is a cheap way to make sure the previous thread loops
                    // around before another thread grabs the lock, does its work,
                    // loops around and requests the lock again ahead of it.
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    //ignored
                }
                if (index != expectedIndex) {
                    System.out.printf("Unexpected thread obtained lock! " +
                            "Expected: %d Actual: %d%n", expectedIndex, index);
                    System.exit(0);
                }

                expectedIndex = (expectedIndex+1) % NUM_THREADS;
                writeLock.unlock();
            }
        }
    }
}