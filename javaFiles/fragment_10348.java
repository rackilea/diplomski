package de.scrum_master.stackoverflow;

import java.util.Scanner;

public class MyApp {
  public static void main(String[] args) {
    System.out.println("----------------------------------------");
    System.out.println("Hi, I am an externally started app.");
    System.out.print("Please enter your name: ");
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    System.out.println("Hello " + name + "!");
    System.out.println("----------------------------------------");
  }
}