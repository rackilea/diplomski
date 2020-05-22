import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Stuff {
    public final ReentrantLock lock = new ReentrantLock();
    public AtomicBoolean isParallel = new AtomicBoolean(true);
    public AtomicInteger currentlyRunningThreadCount = new AtomicInteger();
    public CountDownLatch latch;

    public final static int MAX_WAIT_IN_SECONDS = 20;

    public void doStuff() throws Exception {

        if( !isParallel.get()) {
            System.out.println(threadName() + " Waiting");

            synchronized(this) {
                if(latch == null) {
                    latch = new CountDownLatch(currentlyRunningThreadCount.get());/*Excluding the current thread with -1*/
                    System.out.println("latch count : " + latch.getCount() + " " + latch);
                }
            }
            latch.await(MAX_WAIT_IN_SECONDS, TimeUnit.SECONDS);

            if( !lock.tryLock(MAX_WAIT_IN_SECONDS, TimeUnit.SECONDS)) {
                throw new Exception("Could not acquire lock in specified time");
            }

            currentlyRunningThreadCount.incrementAndGet();

            System.out.println(threadName() + " Woke up");
        }

        try {
            /* <Critical Section> */
            for(int i = 0; i < 3; i++) {
                System.out.println(threadName() + " \tRunning");
                Thread.sleep(2000);
            }
            /* </Critical Section> */
        } finally {

            if(currentlyRunningThreadCount.get() > 0) {
                currentlyRunningThreadCount.decrementAndGet();
            }
            if( !isParallel.get() && latch != null) {
                latch.countDown();
                System.out.println(threadName() + " down latch " + latch.getCount() + " " + latch);
            }

            if(lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }

        System.out.println(threadName() + " Done do stuff");
    }

    public boolean isParallel() {
        return isParallel.get();
    }

    public void setParallel(boolean newValue) throws Exception {
        synchronized(this) {
            if(latch != null) {
                latch.await();
            }

            latch = null;
        }

        isParallel.set(newValue);
    }

    public String threadName() {
        return Thread.currentThread().getName();
    }
}

public class Example {
    public static void main(String[] args) throws Exception {
        System.out.println("Started");
        Stuff stuff = new Stuff();

        Runnable run = () -> {
            try {
                stuff.doStuff();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(null, run, "t1");
        t1.start();
        Thread t2 = new Thread(null, run, "t2");
        t2.start();

        Thread.sleep(2000);
        stuff.setParallel(false);
        Thread t5 = new Thread(null, run, "t5");
        t5.start();

        Thread t6 = new Thread(null, run, "t6");
        t6.start();

        System.out.println("##### main exiting");
    }
}

Started
t1  Running
t2  Running
t1  Running
t2  Running
t5 Waiting
latch count : 0 java.util.concurrent.CountDownLatch@61e7093d[Count = 0]
##### main exiting
t6 Waiting
t5 Woke up
t5  Running
t2  Running
t1  Running
t5  Running
t2 down latch 0 java.util.concurrent.CountDownLatch@61e7093d[Count = 0]
t2 Done do stuff
t1 down latch 0 java.util.concurrent.CountDownLatch@61e7093d[Count = 0]
t1 Done do stuff
t5  Running
t5 down latch 0 java.util.concurrent.CountDownLatch@61e7093d[Count = 0]
t5 Done do stuff
t6 Woke up
t6  Running
t6  Running
t6  Running
t6 down latch 0 java.util.concurrent.CountDownLatch@61e7093d[Count = 0]
t6 Done do stuff