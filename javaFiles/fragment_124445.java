import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestExecutorFairness {
  public static void main(final String[] args) {

    final int interval = 200;
    final int sleeptime = 600;

    final ScheduledExecutorService executor = 
        Executors.newScheduledThreadPool(1);

    final long start = System.currentTimeMillis();

    // schedule task 1
    executor.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(sleeptime);
        } catch (final InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println("1 at "+(System.currentTimeMillis()-start));
      }
    }, interval, interval, TimeUnit.MILLISECONDS);

    // schedule task 2
    executor.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(sleeptime);
        } catch (final InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println("2 at "+(System.currentTimeMillis()-start));


        System.out.println("Submitting 3 to "+executor);
        // submit task 3
        executor.submit(new Runnable() {

          @Override
          public void run() {
              System.out.println("3 at "+(System.currentTimeMillis()-start));
          }
        });
      }
    }, interval, interval, TimeUnit.MILLISECONDS);

  }
}