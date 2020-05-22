package de.scrum_master.app;

public class Application {
  private static MyInterface myInterface;

  public static void main(String[] args) {
    myInterface = new FirstImpl();
    for (int i = 0; i < 5; i++) {
      System.out.println(myInterface.doSomething());
    }

    myInterface = new SecondImpl();
    for (int i = 0; i < 5; i++) {
      System.out.println(myInterface.doSomething());
    }
  }
}