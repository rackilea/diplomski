import java.util.concurrent.CountDownLatch;

public class childTcreat2newthread {

    public static void main(String[] args) throws InterruptedException {
        MyCountDownLatch doneSignal = new MyCountDownLatch(2);

        Target ra = new Target("a",doneSignal);
        Thread t1 = new Thread(ra);
        t1.start();
        doneSignal.await();
        System.out.println("after await ");
        MyCountDownLatch doneSignal1 = new MyCountDownLatch(2);
        new Thread(new Target("b",doneSignal1)).start();
    }
}

class Target implements Runnable {
    private Thread c1;
    private Thread c2;
    String msg;


    Target(String msg, MyCountDownLatch doneSignal) {
        this.msg = msg;

        c1 = new Thread(new Target1("1",doneSignal));

        c2 = new Thread(new Target1("2",doneSignal));
    }

    @Override
    public void run() {
        System.out.println("Start of Target " + msg);
        for (int j = 0; j < 100000; j++) {
            for (int i = 0; i < 10000; i++) {
                if (i % 10000 == 0 && j % 10000 == 0) {
                    System.out.print(msg);
                }
            }
        }

        c1.start();

        c2.start();
//      try {
//          c1.join();
//          c2.join();
//      } catch (InterruptedException e) {
//          // TODO Auto-generated catch block
//          e.printStackTrace();
//      }
        System.out.println("End of Target " + msg);

    }

    public Thread getC1() {
        return c1;
    }

    public Thread getC2() {
        return c2;
    }
}

class Target1 implements Runnable {

    String msg;
    private MyCountDownLatch doneSignal;

    Target1(String msg, MyCountDownLatch doneSignal) {
        this.msg = msg;
        this.doneSignal=doneSignal;
    }

    @Override
    public void run() {
        System.out.println("Start of Target1 " + msg);
        for (int j = 0; j < 100000; j++) {
            for (int i = 0; i < 100000; i++) {
                if (i % 100000 == 0 && j % 10000 == 0) {
                    System.out.print(msg);
                }
            }
        }
        try {

            System.out.println("K");
            doneSignal.countDown();
            System.out.println("End of Target1 " + msg);
        } catch (IllegalMonitorStateException e) {
            System.out.println("\nIllegalMonitorStateException!! in " + msg
                    + "\n");
        }
    }
}

class MyCountDownLatch {
    private int waitersNum;

    public MyCountDownLatch(int waitersNum) {
        this.waitersNum=waitersNum;
    }

    public synchronized void countDown() {
        waitersNum--;
        if (waitersNum==0) {
            notifyAll();
        }
    }

    public synchronized void await() throws InterruptedException {
        wait();
    }       
}