static <T> T getFactory(Class<T> factoryClass) {
    try {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Class<?> beanType = factoryClass.getMethod("get", String.class).getReturnType();
        MethodHandle target = lookup.findStatic(ReflectionUtil.class, "getFactoryBean",
            MethodType.methodType(Object.class, String.class));
        MethodType funcType = target.type().changeReturnType(beanType);
        return (T)LambdaMetafactory.metafactory(
            lookup, "get", MethodType.methodType(factoryClass), funcType, target, funcType)
            .getTarget().invoke();
    } catch(Throwable e) {
      e.printStackTrace();
      return null; // rethink this error handling
    }
}