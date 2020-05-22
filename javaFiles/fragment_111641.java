package ant.test;

import java.util.Random;

public class ThreadTest implements Runnable {

    private int msec;

    public ThreadTest(int msec) {
        this.msec = msec;
    }

    public static void main(String[] args) {
        Random r = new Random();
        for(int i = 0; i < 5; i++)
            new Thread(new ThreadTest(r.nextInt(1000))).start();
    }

    @Override public void run() {
        System.out.println("Thread.activeCount = " + Thread.activeCount() + " activeThead = " + Thread.currentThread().getId());
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread.activeCount(exiting) = " + Thread.activeCount() + " activeThead = " + Thread.currentThread().getId());
        if(Thread.activeCount() == 2) {
            Thread[] tarray = new Thread[5];
            int nThreads = Thread.enumerate(tarray);
            for (int i = 0; i < nThreads; i++) {
                System.out.println(tarray[i].getName());
            }
        }
    }
}