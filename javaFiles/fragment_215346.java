private static <T, U> BiConsumer<T, U> createConsumer(Method method) throws Throwable {
    BiConsumer<T, U> consumer = null;
    final MethodHandles.Lookup caller = MethodHandles.lookup();
    final MethodType biConsumerType = MethodType.methodType(BiConsumer.class);
    final MethodHandle handle = caller.unreflect(method);
    final MethodType type = handle.type();

    CallSite callSite = LambdaMetafactory.metafactory(
          caller,
          "accept",
          biConsumerType,
          type.changeParameterType(0, Object.class).changeParameterType(1, Object.class),
          handle,
          type
    );
    MethodHandle factory = callSite.getTarget();
    try {
        //noinspection unchecked // This is manually checked with exception handling.
        consumer = (BiConsumer<T,U>) factory.invoke();
    }catch (ClassCastException e) {
        LOGGER.log(Level.WARNING, "Unable to cast to BiConsumer<T,U>", e);
    }
    return consumer;
}