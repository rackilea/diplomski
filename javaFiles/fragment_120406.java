static <T> T getFactory(Class<T> factoryClass) {
    T factory =null;
    try {
        final MethodHandles.Lookup lookup = MethodHandles.lookup();
        Class<?> beanType = factoryClass.getMethod("get", String.class).getReturnType();
        final CallSite site = LambdaMetafactory.metafactory(lookup,
                        "get",
                        MethodType.methodType(factoryClass),
                        MethodType.methodType(beanType, String.class),
                        lookup.findStatic(ReflectionUtil.class, "getFactoryBean",
                            MethodType.methodType(Object.class, String.class)),
                        MethodType.methodType(beanType, String.class));
        factory = (T)site.getTarget().invoke();
    } catch(Throwable e) {
      e.printStackTrace();
    }
    return factory;
}