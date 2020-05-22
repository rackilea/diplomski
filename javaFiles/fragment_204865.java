static public Object newInstance(Object obj, Class[] interfaces)
{
  return
java.lang.reflect.Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                                                  interfaces,
                                                  new
MyDynamicProxyClass(obj));
}
That allows me to use the following client code instead:

MyProxyInterface foo = (MyProxyInterface)
  MyDynamicProxyClass.newInstance(obj, new Class[]
{ MyProxyInterface.class });