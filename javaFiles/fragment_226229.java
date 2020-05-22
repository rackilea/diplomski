package de.scrum_master.app;

public class Application {
  public static void main(String[] args) {
    ClassA classA = new ClassA();
    classA.extendedClassMethod1("eleven", 11);
    classA.extendedClassMethod2("twenty-two", 22);
    classA.testMethod("thirty-three", 33);
  }
}