package de.scrum_master.app;

public class PropertyReader {
  public static boolean hasSpecificProperty() {
    return System.getProperty("specificProperty") != null;
  }

  public void doSomething(String info) {
    System.out.println("Doing something " + info);
    hasSpecificProperty();
  }

  public static void main(String[] args) {
    System.clearProperty("specificProperty");
    new PropertyReader().doSomething("with inactive property");
    System.setProperty("specificProperty", "true");
    new PropertyReader().doSomething("with active property");
    System.clearProperty("specificProperty");
  }
}