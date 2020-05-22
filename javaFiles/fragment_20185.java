Enhancer e = new Enhancer();
e.setClassLoader(myClassLoader);
e.setSuperclass(SomeConcreteClass.class);
e.setCallback(new MethodInterceptor() {
  public Object intercept(Object obj, Method method, Object[] args,
        MethodProxy proxy) throws Throwable {
    return proxy.invokeSuper(obj, args);
  }
});
// create proxy using SomeConcreteClass() no-arg constructor
SomeConcreteClass myProxy = (SomeConcreteClass)e.create();
// create proxy using SomeConcreteClass(String) constructor
SomeConcreteClass myProxy2 = (SomeConcreteClass)e.create(
    new Class<?>[] {String.class},
    new Object[] { "hello" });