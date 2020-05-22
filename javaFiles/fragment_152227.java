package de.scrum_master.app;

public class Application {
  private String name;

  public Application(String name) {
    this.name = name;
  }

  public static void main(String[] args) {
    Application application = new Application("my app");
    synchronized (application) {
      try {
        application.doSomething("foo", 11, false);
      }
      catch (RuntimeException e) {}
    }
  }

  private void doSomething(String string, int i, boolean b) {
    throw new RuntimeException("oops");
  }
}