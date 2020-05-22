// IdentityHashMap because all Class objects are singletons
private static final Map<Class<? extends RuntimeException>, ExceptionCreator<?>> MAP
    = new IdentityHashMap<>;


// fill the map in a static initialization block