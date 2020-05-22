package de.scrum_master.app;

public class SecondImpl implements MyInterface {
  @Override
  public A doSomething() {
    return new A("Second");
  }
}