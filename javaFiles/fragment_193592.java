package de.scrum_master.app;

public class Sub extends Base {
  @Override
  public Sub baseAction() {
    return this;
  }

  public Sub subAction() {
    return this;
  }
}