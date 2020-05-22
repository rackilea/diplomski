public class Main {
  public static void main(String args[]) {
    Runnable r = new Runnable() {
      @Override
      public void run() {
        System.out.println("Implementation");
      }
    };
    MyThread gaurav = new MyThread(r);
    gaurav.start();
  }
}

class MyThread extends Thread {

  Runnable runnable;
  public MyThread(Runnable r) {
    // calling Thread(Runnable r) constructor.
    super(r);
    // runnable isn't used anywhere. You can omit the following line.
    runnable = r;
  }

  @Override
  public void run() {
    // First it will run whatever Runnable is given
    // into Thread's constructor.
    super.run();
    System.out.println("Thread");
  }
}