import java.util.concurrent.Semaphore;

public class SyncThreeThreads implements Runnable {

    private final Semaphore previous;

    private final Semaphore next;

    public SyncThreeThreads(Semaphore previous, Semaphore next) {
        this.previous = previous;
        this.next = next;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            waitForPreviousLock();

            System.out.println(Thread.currentThread().getName()+ " Iteration no. "+ (i+1));

            releaseForNext();
        }
    }

    private void releaseForNext() {
        next.release();
    }

    private void waitForPreviousLock() {
        try {
            previous.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    static public void main(String argv[]) throws InterruptedException {

        Semaphore lock1 = new Semaphore(1);
        Semaphore lock2 = new Semaphore(1);
        Semaphore lock3 = new Semaphore(1);

        lock1.acquire();
        lock2.acquire();
        lock3.acquire();

        Thread t1 = new Thread(new SyncThreeThreads(lock3, lock1),"Thread 1");
        Thread t2 = new Thread(new SyncThreeThreads(lock1, lock2),"Thread 2");
        Thread t3 = new Thread(new SyncThreeThreads(lock2, lock3),"Thread 3");

        t1.start();
        t2.start();
        t3.start();

        lock3.release();

        t1.join();
        t2.join();
        t3.join();
    }

}