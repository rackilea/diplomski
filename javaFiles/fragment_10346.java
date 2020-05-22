package de.scrum_master.stackoverflow;

import java.io.File;
import java.io.IOException;

public class Launcher {
  public static void main(String[] args) throws IOException, InterruptedException {
    String classPath = "out/production/SO_ExternalProcessSystemConsole";
    String launchClass = "de.scrum_master.stackoverflow.MyApp";
    String[] arguments = new String[] {
      "cmd", "/c", "start",
      "cmd", "/k", "java", "-cp", classPath, launchClass
    };
    ProcessBuilder pb = new ProcessBuilder(arguments);
    Process process = pb.start();
    process.waitFor();
  }
}