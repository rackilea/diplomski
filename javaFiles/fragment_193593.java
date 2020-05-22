package de.scrum_master.app;

public class Application {
  public static void main(String[] args) {
    new Base().baseAction();
    System.out.println("-----------------");
    new Sub().baseAction();
    System.out.println("-----------------");
    new Sub().subAction();
  }
}