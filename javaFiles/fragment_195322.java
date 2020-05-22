class MyInvocationHandler implements InvocationHandler {
   Object invoke(Object proxy, Method method, Object[] args)  {
     if(method.getName().equals("getValue1")) {
       return new Integer(123);
     } else if(method.getName().equals("setValue")) {
           ...
     }
     ...
  }
}

InvocationHandler handler = new MyInvocationHandler();
IMyEntity e = (IMyEntity) Proxy.newProxyInstance(IMyEntity.class.getClassLoader(),
                                                 new Class[] { IMyEntity.class },
                                                 handler);