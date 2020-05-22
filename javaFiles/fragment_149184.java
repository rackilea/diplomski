package de.scrum_master.app;

import java.io.IOException;
import java.util.Random;

public class ExternalCommandExecutor {
  private static final Random RANDOM = new Random();

  public static String execute(final String cmd, final String error, final boolean runInBackground, final boolean retry) throws IOException {
    long sleepTime = 100 + 100 * (RANDOM.nextInt(3));
    System.out.println("Executing external command: " + cmd + ", sleeping for " + sleepTime + " ms");
    try {
      Thread.sleep(sleepTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Finished execution: " + cmd);
    return cmd;
  }
}