class MyCallback implements MethodInterceptor{
       public Object intercept(Object obj,
                                      Method method,
                                      Object[] args,
                                      MethodProxy proxy){
            Object stuffToReturn = null;
            if ("method1".equals(method.getName()) {
                 //Class B's method1 impl 
            } else {
                 //call the original method in class A
                 stuffToReturn  = method.invoke(proxy, args);
            }

            return stuffToReturn;   
        }
    }