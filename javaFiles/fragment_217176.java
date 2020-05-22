public class MyClass implements MyInter {

  @Override 
  public final void foo() {
    //Cant touch this
  }

  @Override
  public String bar() {
    return "foo";
  }

}