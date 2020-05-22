public Class MyDynamicProxyClass implements
java.lang.reflect.InvocationHandler
{
  Object obj;
  public MyDynamicProxyClass(Object obj)
  { this.obj = obj; }
  public Object invoke(Object proxy, Method m, Object[] args) throws
Throwable
  {
    try {
      // do something
    } catch (InvocationTargetException e) {
      throw e.getTargetException();
    } catch (Exception e) {
      throw e;
    }
    // return something
  }
}