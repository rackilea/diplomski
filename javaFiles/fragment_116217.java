public class DebugProxy implements java.lang.reflect.InvocationHandler {

   private Object obj;

   private DebugProxy(Object obj) {
      this.obj = obj;
   }

   public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
   {
       System.out.println("before method " + m.getName());
       return m.invoke(obj, args); 
   }
}

Foo original = ... ;
Foo wrapper = (Foo) java.lang.reflect.Proxy.newProxyInstance(
    original.getClass().getClassLoader(),
    original.getClass().getInterfaces(),
    new DebugProxy(original));
wrapper.bar(...);