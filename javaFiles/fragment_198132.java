public class Step4 {

  public int getA() {
    return a;
  }

  public void addToA(int number) {
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    for(int i=0;i<number;i++)
        this.a = this.a + 1;
  }

  public void multiplyA(int number) {
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    this.a = this.a * number;
  }

  int a = 2;
  static Step4 s4;

  public static void main(String[] args) throws InterruptedException {

    for (int i = 0; i < 10; i++) {
        s4 = new Step4();
        doRun();
        System.out.println("*******");
    }
  }

  private static void doRun() throws InterruptedException {
    Thread thread1 = new Thread(new Runnable() {
        @Override
        public void run() {
            s4.addToA(5);
        }
    });

    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            s4.multiplyA(3);
        }
    });

    Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {
            s4.addToA(6);
        }
    });

    Thread thread4 = new Thread(new Runnable() {
        @Override
        public void run() {
            s4.addToA(4);
        }
    });


    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();

    thread1.join();
    thread2.join();
    thread3.join();
    thread4.join();

    System.out.println(s4.getA());

  }

}