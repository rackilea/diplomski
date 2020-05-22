private static @Nullable Method findMethod(Class<?> klass,
                                           final String methodName,
                                           final Object... args) {

    @Nullable Method candidate = null;

    classSearch:
    while (klass != null) {

        // Check all the class' methods for a matching one.
        methodSearch:
        for (final Method method : klass.getDeclaredMethods()) {
            if (!method.getName().equals(methodName)) continue;

            final Class<?>[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length != args.length) continue;

            // Check all parameters can come from the given args.
            for (int i = 0; i < args.length; i++) {
                if (!parameterTypes[i].isInstance(args[i])) continue methodSearch;
            }

            candidate = method;
            break classSearch;
        }

        // No matching method, check super class.
        klass = klass.getSuperclass();
    }

    // May be 'null' if no match was found.
    // Throw an Exception if this isn't a valid outcome in your case.
    return candidate;
}