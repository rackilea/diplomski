public class VolatileExample extends Thread {
  private int countDown = 2;
  private volatile int d = 0;

  public VolatileExample(String name) {
    super(name);
  }

  public String toString() {
    return super.getName() + ": countDown " + countDown;
  }

  public void run() {
    while(true) {
      d = d + 1;
      System.out.println(this + ". Value of d is " + d);
      if(--countDown == 0) return;
    }
  }

  public static void main(String[] args) {
    VolatileExample ve1 = new VolatileExample("first thread");
    ve1.start();
    VolatileExample ve2 = new VolatileExample("second thread");
    ve2.start();
  }
}