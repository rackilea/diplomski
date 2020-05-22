public class workerThread implements Runnable {
  private Driver driver;

  public workerThread(Driver d, Class c) {
    this.driver = d;
    //do whatever you are doing with existing Classs parameter
  }

  public void run() {
    driver.setMyVariable("test");
  }