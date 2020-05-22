import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

final class Parallels
{

  private static final int RUNS = 10;

  public static void main(String... argv)
    throws Exception
  {
    System.out.println("Testing \"clean\" task.");
    flavor(CleanTask::new);
    System.out.println("Testing \"dirty\" task.");
    flavor(DirtyTask::new);
  }

  private static void flavor(Supplier<Callable<Long>> tasks)
    throws InterruptedException, ExecutionException
  {
    ExecutorService warmup = Executors.newFixedThreadPool(100);
    for (int i = 0; i < 100; ++i)
      warmup.submit(tasks.get());
    warmup.shutdown();
    warmup.awaitTermination(1, TimeUnit.DAYS);
    ExecutorService workers = Executors.newFixedThreadPool(2);
    long t1 = test(1, tasks, workers);
    long t2 = test(2, tasks, workers);
    System.out.printf("Average task time: one thread = %d ms; two threads = %d ms%n", t1 / (1 * RUNS), t2 / (2 * RUNS));
    workers.shutdown();
  }

  private static long test(int n, Supplier<Callable<Long>> tasks, ExecutorService workers)
    throws InterruptedException, ExecutionException
  {
    long sum = 0;
    for (int i = 0; i < RUNS; ++i) {
      List<Callable<Long>> batch = new ArrayList<>(n);
      for (int t = 0; t < n; ++t)
        batch.add(tasks.get());
      List<Future<Long>> times = workers.invokeAll(batch);
      for (Future<Long> f : times)
        sum += f.get();
    }
    return TimeUnit.NANOSECONDS.toMillis(sum);
  }

  /**
   * Do something on the CPU without creating any garbage, and return the 
   * elapsed time.
   */
  private static class CleanTask
    implements Callable<Long>
  {
    @Override
    public Long call()
    {
      long time = System.nanoTime();
      long x = 0;
      for (int i = 0; i < 15_000_000; i++)
        x ^= ThreadLocalRandom.current().nextLong();
      if (x == 0)
        throw new IllegalStateException();
      return System.nanoTime() - time;
    }
  }

  /**
   * Do something on the CPU that creates a lot of garbage, and return the 
   * elapsed time.
   */
  private static class DirtyTask
    implements Callable<Long>
  {
    @Override
    public Long call()
    {
      long time = System.nanoTime();
      String s = "";
      for (int i = 0; i < 10_000; i++)
        s += (int) (ThreadLocalRandom.current().nextDouble() * 13);
      if (s.length() == 10_000)
        throw new IllegalStateException();
      return System.nanoTime() - time;
    }
  }

}