package de.scrum_master.app;

public interface MyInterface {
  void one();
  void two();

  public static aspect MarkerAnnotationInheritor {
    // Implementing classes should inherit marker annotation
    declare @type: MyInterface+ : @Marker;
    // Overriding methods 'two' should inherit marker annotation
    declare @method : void MyInterface+.two() : @Marker;
  }
}