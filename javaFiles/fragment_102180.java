package de.scrum_master.stackoverflow;

public class AnotherClass {
  public String doSomething(FinalClass finalClass) {
    return finalClass.finalMethod();
  }

  public String doSomethingElse() {
    return FinalClass.finalStaticMethod();
  }
}