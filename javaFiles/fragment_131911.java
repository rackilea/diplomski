package so.thread.errcondition;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

  public static Random rand = new Random();

  public static ExecutorService workers = Executors.newFixedThreadPool(5);

  // NOTE, this executor has a FIXED size of 1 for in-order processing
  public static ExecutorService watcher = Executors.newFixedThreadPool(1);

  public static AtomicBoolean errorCondition = new AtomicBoolean(false);
  public static AtomicInteger errorCount = new AtomicInteger(0);

  public static Integer MAX_ERRORS = 5;

  public static void main(String[] args) throws Exception {


    int jobs = 1000;

    for (int i = 0; i < jobs; i++) {
      workers.submit(getWork());
    }

    Thread.sleep(TimeUnit.SECONDS.toMillis(5));

  }

  // parallelizable task, the number of parallel workers is irrelevant
  public static Runnable getWork() {
    return new Runnable() {
      @Override
      public void run() {

        // fail fast
        if (errorCondition.get()) {
          System.out.println("%%% MAX_ERRORS of [" + MAX_ERRORS + "] occurred, skipping task");
          return;
        }
        // do work
        if (rand.nextBoolean()) {
          // GOOD JOB
          System.out.println("+++ GOOD RESULT");
          submitDoneTask(true);
        } else {
          // ERROR
          System.out.println("*** BAD RESULT");
          submitDoneTask(false);
        }
      }
    };
  }

  public static void submitDoneTask(final boolean success) {
    watcher.submit(new Runnable() {
      @Override
      public void run() {
        if (!errorCondition.get() && success) {
          errorCount.set(0);
        } else {
          int errors = errorCount.incrementAndGet();
          if (errors >= MAX_ERRORS) {
            errorCondition.set(true);
          }
        }
      }
    });
  }
}