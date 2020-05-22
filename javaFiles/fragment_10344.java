package de.scrum_master.stackoverflow;

import java.io.File;
import java.io.IOException;

public class Launcher {
  public static void main(String[] args) throws IOException, InterruptedException {
    String classPath = "out/production/SO_ExternalProcessSystemConsole";
    String launchClass = "de.scrum_master.stackoverflow.MyApp";
    File workDir = new File(".");
    System.console().printf("Hi, I am the launcher app!%n");

    String[] arguments = new String[] {
//      "cmd", "/c",
      "java", "-cp", classPath,
      launchClass
    };
    ProcessBuilder pb = new ProcessBuilder(arguments);
    pb.environment().putAll(System.getenv());
    pb.directory(workDir);
    pb.inheritIO();

    Process process = pb.start();
    process.waitFor();
  }
}