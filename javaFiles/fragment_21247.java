package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockableTask is a nice demonstration
 * @author Michael
 * @link https://stackoverflow.com/questions/32680954/reetrant-locks-in-java
 * @since 9/20/2015 11:25 AM
 */
public class LockableTask implements Runnable {

    private static final int DEFAULT_WAIT = 100;
    private static final int DEFAULT_TIMEOUT = 1000;
    private static final int DEFAULT_THREADS = 5;

    private ReentrantLock lock;
    private int waitPeriod;
    private int timeoutPeriod;
    private boolean halfHeartedLockRequest;

    public static void main(String[] args) {
        long begTime = System.currentTimeMillis();
        System.out.println("Start reentrant lock test");
        try {
            LockableTask lockableTask = new LockableTask(true, false);
            int numThreads = (args.length > 0) ? Integer.parseInt(args[0]) : DEFAULT_THREADS;
            List<Thread> threads = new ArrayList<>(numThreads);
            for (int i = 0; i < numThreads; ++i) {
                threads.add(new Thread(lockableTask));
            }
            for (Thread thread : threads) {
                thread.start();
            }
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("Complete reentrant lock test in %d milliseconds", (endTime-begTime)));
        }
    }

    public LockableTask() {
        this(false, false, DEFAULT_WAIT, DEFAULT_TIMEOUT);
    }

    public LockableTask(boolean halfHeartedLockRequest, boolean fair) {
        this(halfHeartedLockRequest, fair, DEFAULT_WAIT, DEFAULT_TIMEOUT);
    }

    public LockableTask(boolean halfHeartedLockRequest, boolean fair, int waitPeriod, int timeoutPeriod) {
        this.halfHeartedLockRequest = halfHeartedLockRequest;
        this.lock = new ReentrantLock(fair);
        this.waitPeriod = (waitPeriod > 0) ? waitPeriod : DEFAULT_WAIT;
        this.timeoutPeriod = (timeoutPeriod > 0) ? timeoutPeriod : DEFAULT_TIMEOUT;
    }

    @Override
    public void run() {
        System.out.println(String.format("Thread '%s' requests lock ", Thread.currentThread().getName()));
        if (this.halfHeartedLockRequest) {
            this.lock.tryLock();
        } else {
            this.lock.lock();
        }
        try {
            System.out.println(String.format("Thread '%s' acquires lock for %d ", Thread.currentThread().getName(), this.waitPeriod));
            TimeUnit.MILLISECONDS.sleep(this.waitPeriod);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
            System.out.println(String.format("Thread '%s' releases lock ", Thread.currentThread().getName()));
        }
    }
}