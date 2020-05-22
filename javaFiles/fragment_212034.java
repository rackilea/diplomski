MyClass proxy = (List<String>)Enhancer.create(MyClass.class, new MyInvocationHandler());
proxy.aMethodToInvoke();
.
.
.
class MyInvocationHandler implements MethodInterceptor {
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before we invoke the method");
        Object retObj = proxy.invoke(obj, args);
        System.out.println("After we invoke the method");
        return retObj;
    }
}