public class MyClass {

  private static final CountDownLatch latch = new CountDownLatch(1);

  public void initialise() {
    initStuff();
    latch.countDown();
  }

  public void doStuff() {
    try {
      latch.await();
    } catch (InterruptedException ex) {
      throw new RuntimeException("Uh oh!", ex);
    }
    doOtherStuff();
  }

}