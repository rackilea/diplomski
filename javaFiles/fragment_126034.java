package de.scrum_master.base;

public abstract class ApplicationBase {
  public abstract void doSomething(String name);

  public String convert(int number) {
    return ((Integer) number).toString();
  }
}