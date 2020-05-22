package de.scrum_master.stackoverflow;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Launcher {
  public static void main(String[] args) throws IOException, InterruptedException {
    String classPath = "out/production/SO_ExternalProcessSystemConsole";
    String launchClass = "de.scrum_master.stackoverflow.MyApp";
    File workDir = new File(".");
    System.out.println("Hi, I am the launcher app!");

    String[] arguments = new String[] { "cmd", "/c", "java", "-cp", classPath, launchClass };
    ProcessBuilder pb = new ProcessBuilder(arguments);
    pb.environment().putAll(System.getenv());
    pb.directory(workDir);
    pb.inheritIO();
    Process process = pb.start();
    process.waitFor();

    System.out.print("What is your favourite city? ");
    Scanner scanner = new Scanner(System.in);
    String city = scanner.nextLine();
    System.out.println("I guess that " + city + " is a nice place.");
  }
}