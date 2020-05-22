package de.scrum_master.app;

public class MyObjectGraphBuilder {
  @Builder
  ClassA objectA() {
    return new ClassA(objectB());
  }

  @Builder
  ClassB objectB() {
    return new ClassB();
  }

  public static void main(String[] args) {
    MyObjectGraphBuilder builder = new MyObjectGraphBuilder();
    System.out.println(builder.objectB());
    System.out.println(builder.objectA());
    System.out.println(builder.objectB());
    System.out.println(builder.objectA());
    System.out.println(builder.objectB());
    System.out.println(builder.objectA());
  }
}