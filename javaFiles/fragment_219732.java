static <T> Function<Request, T> reflect(String getterName, Class<T> resultType)
            throws ReflectiveOperationException {
    MethodHandles.Lookup l=MethodHandles.lookup();
    MethodType getter=MethodType.methodType(resultType);
    MethodHandle target = l.findVirtual(Request.class, getterName, getter);
    getter=target.type();
    try {
        return (Function)LambdaMetafactory.metafactory(l, "apply",
            MethodType.methodType(Function.class),
            getter.generic(), target, getter).getTarget().invokeExact();
    } catch(Throwable ex) {
        throw new ReflectiveOperationException(ex);
    }
}