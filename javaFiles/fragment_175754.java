package de.scrum_master.app;

public class FirstImpl implements MyInterface {
  @Override
  public A doSomething() {
    return new A("First");
  }
}