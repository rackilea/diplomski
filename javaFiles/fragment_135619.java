SimpleBean simpleBeanInstance = new SimpleBean();

MethodHandles.Lookup caller = MethodHandles.lookup();
MethodType getter=MethodType.methodType(Object.class);
MethodHandle target=caller.findVirtual(SimpleBean.class, "getObj", getter);
MethodType func=target.type();
CallSite site = LambdaMetafactory.metafactory(caller,
    "apply",
    MethodType.methodType(Function.class),
    func.generic(), target, func);

MethodHandle factory = site.getTarget();
Function r = (Function)factory.invoke();
assertEquals( "myCustomObject", r.apply(simpleBeanInstance));