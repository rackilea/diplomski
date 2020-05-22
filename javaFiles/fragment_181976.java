// Demo.java
public class Demo
{
  public static void main(String[] args)
  {
    A a = new B();
    B b = new B();

    // Can only call A's public methods
    a.x();
    a.y();
    // a.a(); Can't use
    // a.b(); Can't use

    // Can call all public methods
    b.a();
    b.b();
    b.x();
    b.y();
  }
}