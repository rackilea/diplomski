package de.scrum_master.app;

import java.io.IOException;

public class ExternalCommandExecutor {
  public static String execute(final String cmd, final String error, final boolean runInBackground, final boolean retry) throws IOException {
    System.out.println("Executing external command: " + cmd);
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return cmd;
  }
}