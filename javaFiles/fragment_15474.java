public static <T, R> ISetter<T, R> getSetter(Class<T> clazz, String fieldName,
        Class<R> fieldType) throws Throwable {

    MethodHandles.Lookup caller = MethodHandles.lookup();
    MethodType setter = MethodType.methodType(void.class, fieldType);
    MethodHandle target = caller.findVirtual(clazz, computeSetterName(fieldName), setter);
    MethodType func = target.type();

    CallSite site = LambdaMetafactory.metafactory(
            caller,
            "set",
            MethodType.methodType(ISetter.class),
            func.erase(),
            target,
            func
    );

    MethodHandle factory = site.getTarget();
    ISetter<T, R> r = (ISetter<T, R>) factory.invoke();

    return r;
}