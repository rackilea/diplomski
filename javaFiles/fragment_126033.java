package de.scrum_master.app;

import de.scrum_master.base.BasicInterface;

public class ApplicationOne implements BasicInterface {
  @Override
  public void doSomething(String name) {
    System.out.println("Doing something with " + name);
  }

  @Override
  public String convert(int number) {
    return new Integer(number).toString();
  }

  public static void main(String[] args) {
    System.out.println("BasicInterface implementation");
    ApplicationOne application = new ApplicationOne();
    application.doSomething("Joe");
    System.out.println("Converted number = " + application.convert(11));
  }
}