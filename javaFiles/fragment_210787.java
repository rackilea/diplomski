public abstract class Parent {

  interface Interface1 {
      //Specifications of methods that all child nested classes must have
  }

  interface Interface2 {
      //Specifications of methods that all child nested classes must have
  }

  public abstract Interface2 func(Interface1 obj);

}

public class Child extends Parent {

  private static class Impl1 implements Interface1 {
      //Implementations of methods in Interface1 as they pertain to Child
  }
  private static class Impl2 implements Interface2 {
      //Implementations of methods in Interface2 as they pertain to Child
  }


  @Override
  public Interface2 func(Interface1 obj) {
    //Should only have to use methods declared in Interface1
    //Thus should have no need to cast obj.

    //Will return an instance of Impl2
    return null;
  }
}