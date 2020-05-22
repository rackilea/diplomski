abstract class D {
  protected int i=10;
  protected String str="java";

  D(){
    System.out.println("called abstract class constructor");
  }

  protected abstract void m1();

  void m2() {
    System.out.println("called m2() in abstract class! i=" + i);
  }
}




public class DemoAbs extends D{

  // access instance variable here from abstract class

  DemoAbs() {
    System.out.println("called DemoAbs class constr");
  }

  @Override
  protected void m1() {
    i = 30;
    System.out.println("inside m1() method");
  }

  public static void main(String[] args) {
    DemoAbs d=new DemoAbs();
    d.m1();  // Output: "inside m1() method"
    d.m2();  // Output: "called m2() in abstract class! i=30"
  }
}