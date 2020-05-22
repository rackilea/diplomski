class ServiceDemultiplexer implements InvocationHandler {

     ServiceDemultiplexer(Object services[]) {
       ... 
     }

     public Object invoke(Object proxy, Method m, Object[] args)
    throws Throwable
     {
        ...
     }
}