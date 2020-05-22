import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Main implements Runnable {
    private Lock lock = new ReentrantLock();

    public void method1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " entered method1.");

        Thread.sleep(1000);

        lock.lock();

        System.out.println(Thread.currentThread().getName() + " ackquired lock.");

        Thread.sleep(1000);
    }

    public void method2() {
        System.out.println(Thread.currentThread().getName() + " entered method2.");

        lock.unlock();

        System.out.println(Thread.currentThread().getName() + " released lock.");
    }

    public void run() {
        try{
            method1();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            method2();
        }
    }

    public static void main(String [] args) {
        Runnable runnable = new Main();

        new Thread(runnable, "ThreadA").start();
        new Thread(runnable, "ThreadB").start();
    }
}