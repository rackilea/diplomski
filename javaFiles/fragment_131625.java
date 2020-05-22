package de.scrum_master.app;

public class ClassA {
  private ClassB objectB;

  public ClassA(ClassB objectB) {
    this.objectB = objectB;
  }

  @Override
  public String toString() {
    return "ClassA@" +hashCode() + "(" + objectB + ")";
  }
}