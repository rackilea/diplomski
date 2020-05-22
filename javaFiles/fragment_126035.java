package de.scrum_master.app;

import de.scrum_master.base.ApplicationBase;

public class ApplicationTwo extends ApplicationBase {
  @Override
  public void doSomething(String name) {
    System.out.println("Doing something with " + name);
  }

  public static void main(String[] args) {
    System.out.println("ApplicationBase subclass");
    ApplicationTwo application = new ApplicationTwo();
    application.doSomething("Joe");
    System.out.println("Converted number = " + application.convert(11));
  }
}