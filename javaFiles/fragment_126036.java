package de.scrum_master.app;

public class UnwantedApplication {
  public void sayHello(String name) {
    System.out.println("Hello " + name);
  }

  public String transform(int number) {
    return new Integer(number).toString();
  }

  public static void main(String[] args) {
    System.out.println("Unwanted application");
    UnwantedApplication application = new UnwantedApplication();
    application.sayHello("Joe");
    System.out.println("Transformed number = " + application.transform(11));
  }
}