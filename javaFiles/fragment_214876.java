package de.scrum_master.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PropertyReader {
  private static int callCounter = 0;
  private static final Random RANDOM = new Random();

  public static boolean hasSpecificProperty() {
    synchronized (RANDOM) {
      callCounter++;
    }
    try {
      Thread.sleep(25);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return System.getProperty("specificProperty") != null;
  }

  public void doSomething(String info) {
    System.out.println("Doing something " + info);
    hasSpecificProperty();
  }

  public static int doStuff(final int numThreads, final boolean specificPropertyState) throws InterruptedException {
    if (specificPropertyState)
      System.setProperty("specificProperty", "true");
    else
      System.clearProperty("specificProperty");

    List<Thread> threads = new ArrayList<>();
    long startTime = System.currentTimeMillis();
    callCounter = 0;

    for (int i = 0; i < numThreads; i++) {
      Thread newThread = new Thread(() -> {
        new PropertyReader().doSomething("with active property");
      });
      threads.add(newThread);
      newThread.start();
    }

    for (Thread thread : threads)
      thread.join();

    System.clearProperty("specificProperty");
    System.out.println("Call counter = " + callCounter);
    System.out.println("Duration = " + (System.currentTimeMillis() - startTime) + " ms");
    return callCounter;
  }

  public static void main(String[] args) throws InterruptedException {
    final int NUM_THREADS = 10;
    int callCounterInactiveProperty = doStuff(NUM_THREADS, false);
    int callCounterActiveProperty = doStuff(NUM_THREADS, true);
    int callCounterDelta = callCounterActiveProperty - callCounterInactiveProperty;
    if (callCounterDelta != 3 * NUM_THREADS)
      throw new RuntimeException("Call counter delta should be " + 3 * NUM_THREADS + ", not " + callCounterDelta);
  }
}