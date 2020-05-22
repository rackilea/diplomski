SimpleBean simpleBeanInstance = new SimpleBean();

MethodHandles.Lookup caller = MethodHandles.lookup();
MethodType getter=MethodType.methodType(Object.class);
MethodHandle target=caller.findVirtual(SimpleBean.class, "getObj", getter);
CallSite site = LambdaMetafactory.metafactory(caller,
    "get", // include types of the values to bind:
    MethodType.methodType(Supplier.class, SimpleBean.class),
    getter, target, getter);

MethodHandle factory = site.getTarget();
factory = factory.bindTo(simpleBeanInstance);
Supplier r = (Supplier) factory.invoke();
assertEquals( "myCustomObject", r.get());