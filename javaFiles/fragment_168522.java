public class SuperClass {

  public void method1(){

  }
}

public class SubClass extends SuperClass {
  public void method2()
  {

  }
}

SubClass sub = new SubClass();
sub.method1();  //Valid through inheritance from SuperClass
sub.method2();  // Valid

SuperClass superClass = new SubClass();
superClass.method1();
superClass.method2(); // Compilation Error since Reference is of SuperClass so only SuperClass methods are accessible.