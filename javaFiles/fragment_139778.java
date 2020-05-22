public class myClass
{
  private final Object method1Lock = new Object();
  private final Object method2Lock = new Object();

  void method1()
  {
    synchronized(method1Lock)
    {
      // ...
    }
  }

  void method2()
  {
    synchronized(method2Lock)
    {
      // ...
    }
  }
}