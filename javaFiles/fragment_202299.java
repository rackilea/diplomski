package de.scrum_master.app;

public class Application {
  private int id;
  private String name;

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void doSomething() {
    System.out.println("Doing something");
  }

  public static void main(String[] args) {
    Application application = new Application();
    application.setId(11);
    application.setName("John Doe");
    application.doSomething();
    System.out.println(application.getId() + " - " + application.getName());
  }
}