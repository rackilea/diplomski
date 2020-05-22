// Java-y pseudo-code...
Map<Class<? extends SuperClass>,Function<V,R>> doMethods = new HashMap<>();
doMethods.add(FooClass.class, FooDoMethod.INSTANCE);
doMethods.add(BarClass.class, BarDoMethod.INSTANCE);
...
public R doMethod(V it) {
    Class<? extends V> cls = it.getClass();
    Function<? extends V,R> fn = doMethods.get(cls);
    if(fn==null)
        throw new UnsupportedOperationException(
            "Can't doMethod() on a "+cls.getName());
    return fn.apply(it);
}