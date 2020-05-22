InvocationHandler bInvocationHandler = new BInvocationHandler() {
    public Object invoke(Object proxy, Method method, Object[] args) {
       // Check this is someMethod
       // a.someMethodOfBIsCalled();
       // b.someMethod();
    }
};

B decoratedB = (B) Proxy.newProxyInstance(B.class.getClassLoader(),
    new Class[] { Foo.class }, bInvocationHandler );