public Object intercept(Object obj, Method method, Object[] args,
        MethodProxy proxy) throws Throwable
{
    if ("valueMethod".equals(method.getName()))
        return constantValue;
    else if("sayHello".equals(method.getName())) {
        System.out.println("before original sayHello()");
        // equivalent of saying super.sayHello() inside subclass
        Object result=proxy.invokeSuper(obj, args);
        System.out.println("after original sayHello()");
        return result;
    }
    else return null;
}