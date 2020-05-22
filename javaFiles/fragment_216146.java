package de.scrum_master.app;

public class Application {
  public static void main(String[] args) {
    Application application = new Application();
    application.doSomething();
    application.doSomethingElse();
    application.doSomethingWeird();
  }

  @Transaction(myFlag = true)
  public void doSomething() {
    System.out.println("Doing something");
  }

  public void doSomethingElse() {
    System.out.println("Doing something else\n");
  }

  @Transaction(myFlag = false)
  public void doSomethingWeird() {
    System.out.println("Doing something weird");
    throw new RuntimeException("oops");
  }
}