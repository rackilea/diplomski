public Handler(Method method, Object instance, EventHandle handle) throws Throwable {
    this.method = method;

    log.info(method.getGenericReturnType() + "");

    for(Type type : method.getParameterTypes()) {
        log.info(type.getTypeName());
    }

    this.handle = handle;
    this.lookup = MethodHandles.lookup();
    this.methodHandle = lookup.unreflect(method);
    MethodType type = methodHandle.type();
    // add the type of the instance to the factory method
    MethodType factoryType=MethodType.methodType(EventHandler.class,type.parameterType(0));
    // and remove it from the function signature
    type=type.dropParameterTypes(0, 1);

    log.info("" + type.toMethodDescriptorString());

    this.invoker = (EventHandler)LambdaMetafactory.metafactory(lookup,
        "handle", factoryType, type, methodHandle, type).getTarget()
    // use invoke instead of invokeExact as instance is declared as Object
        .invoke(instance);
}