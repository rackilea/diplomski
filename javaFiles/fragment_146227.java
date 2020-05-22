package de.scrum_master.app;

public class Application {
  @Id(id = "my ID")
  String key;

  public static void main(String[] args) {
    Application application = new Application();
    application.methodToBeIntercepted();
  }

  @Auditable(event = "xxx", entity = "yyy")
  public void methodToBeIntercepted() {
    key = "I am the key";
  }
}