package p1;

import org.junit.Test;

public class MyTest implements Runnable {

  private MyClass mc;

  /**
   * @throws InterruptedException
   */
  @Test
  public void parallelTest() throws InterruptedException {
      this.mc = new MyClass();
      Thread thread1 = new Thread(this);
      Thread thread2 = new Thread(this);
      thread1.start();
      thread2.start();
      thread1.join();
      thread2.join();
  }

  public void run() {
     if(mc != null) {
        System.out.println("ph not null");
     } else {
        System.out.println("ph null"); // THIS CODE GETS EXECUTED
     }
     // some code
  }
}