static <T> Handler<T> createHandler(MethodHandles.Lookup lookup,
        Object instance, Method m, Class<T> arg) throws Throwable {

    MethodHandle mh=lookup.unreflect(m);
    MethodType t=mh.type();
    Class<?> receiver=t.parameterType(0);
    if(t.parameterCount()!=2
    || !receiver.isAssignableFrom(instance.getClass())
    || !t.parameterType(1).isAssignableFrom(arg))
      throw new IllegalArgumentException(m+" not suitable for Handler<"+arg.getName()+'>');
    t=t.dropParameterTypes(0, 1);
    return (Handler)LambdaMetafactory.metafactory(lookup, "accept",
        MethodType.methodType(Handler.class, receiver),
        t.changeParameterType(0, Object.class), mh, t)
        .getTarget().invoke(instance);
}