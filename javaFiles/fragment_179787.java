public class TestCountDownLatch {

  private static CountDownLatch latch;

  public static void main(String[] args) {

    latch = new CountDownLatch(1);
    ExecutorService pool = Executors.newCachedThreadPool();
    for (int i = 0; i < 1; ++i) {
      pool.execute(new Worker(i));
    }
  }

  public static class Worker implements Runnable {

    private int number;

    public Worker(int number) {
      this.number = number;
    }

    @Override
    public void run() {

      try {
        System.out.println(number + " is sleeping...");
        Thread.sleep((long) (Math.round(Math.random() * 1000)));
      } catch (InterruptedException ex) {
      }

      System.out.println(number + " is Completed...");
      latch.countDown();

      if (latch.getCount() == 0) {

        System.out.println(number + " was last...");

      }

    }
  }
}