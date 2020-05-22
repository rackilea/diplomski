package de.scrum_master.app;

public class Application {
  public static void main(String[] args) {
    new MyClassWithLogger().doSomething();
    new MyClassWithoutLogger().doSomething();
  }
}