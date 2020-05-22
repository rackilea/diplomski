class Test {
    synchronized static void printTest(int n) {
        for (int i = 1; i <= 10; i++) {
            if(Thread.interrupted())
                break;
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
            }
        }
    }
 }

 class MyThread1 extends Thread {
    public void run() {
        Test.printTest(1);
    }
 }

 class MyThread2 extends Thread {
    public void run() {
        Test.printTest(10);
    }
 }

 public class TestSynchronization {
    public static void main(String t[]) throws InterruptedException {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        t1.start();
        t2.start();

        t1.interrupt();
        t1.join();
    }

 }