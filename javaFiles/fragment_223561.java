@Override
public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("Proxy: calling " + method);
    // Default methods are public non-abstract instance methods
    // declared in an interface.
    if (((method.getModifiers() & (Modifier.ABSTRACT | Modifier.PUBLIC | Modifier.STATIC)) ==
            Modifier.PUBLIC) && method.getDeclaringClass().isInterface()) {
    // see https://rmannibucau.wordpress.com/2014/03/27/java-8-default-interface-methods-and-jdk-dynamic-proxies/
    final Constructor<MethodHandles.Lookup> constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, int.class);
        if (!constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
        final Class<?> declaringClass = method.getDeclaringClass();
        return constructor.newInstance(declaringClass, MethodHandles.Lookup.PRIVATE)
                .unreflectSpecial(method, declaringClass)
                .bindTo(proxy)
                .invokeWithArguments(args);

    }
    return null;
}