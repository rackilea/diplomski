// A.java
public class A
{
  public void x()
  {
    z("X");
  }

  public void y()
  {
    z("Y");
  }

  protected void z(String message)
  {
    System.out.println(message);
  }
}

// B.java
public class B extends A
{
  public void a()
  {
    z("A");
  }

  public void b()
  {
    z("B");
  }
}