package de.scrum_master.app;

public class Application {
  public static void main(String[] args) {
    System.out.println(new Application().createFoo());
  }

  public Foo createFoo(Object... args) {
    return null;
  }
}