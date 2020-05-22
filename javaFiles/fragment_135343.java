import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class RandomThread implements Runnable {
  private final Random rand;
  private final int min;
  private final int max;
  private int rnd;

  public int getRnd() {
    return rnd;
  }

  @Override
  public void run() {
    final String threadName = Thread.currentThread().getName();
    System.out.println("Thread " + threadName + " started. Sleeping for 5000ms to simulate work being done...");
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    final int randomNumber = rand.nextInt((max - min) + 1) + min;
    this.rnd = randomNumber;
    System.out.println("Generated [" + rnd + "] in thread " + threadName);
  }


  public RandomThread(int min, int max) {
    this.min = min;
    this.max = max;
    rand = new Random();
  }
}

class TestClass {

  private static final int NUM_THREADS = 10;

  public static void main(String[] args) {

    final List<RandomThread> runnables = new ArrayList<>();
    for (int i = 0; i < NUM_THREADS; i++) {
      runnables.add(new RandomThread(1, 10));
    }
    System.out.println("Runnables created.");

    final List<Thread> threads = new ArrayList<>();
    for (final RandomThread runnable : runnables) {
      threads.add(new Thread(runnable));
    }
    System.out.println("Threads created.");

    for (final Thread thread : threads) {
      thread.start();
    }
    System.out.println("Threads started.");

    for (final Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Threads stopped (complete).");

    int total = 0;
    for (final RandomThread runnable : runnables) {
      total += runnable.getRnd();
    }
    System.out.println("Total: " + total);
  }
}