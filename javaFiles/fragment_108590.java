public class MyClass
{
  public void foo(Integer i)
  {
    System.out.println("Integer");
  }
  public void foo(String s)
  {
    System.out.println("String");
  }
  public static void main(String[] args)
  {
    Object o1=new String("Hello world");
    foo(o1);
    Object o2=new Double(42);
    foo(o2);
  }
}