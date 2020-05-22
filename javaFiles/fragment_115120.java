static Class<?>[] findInterfaces(final Class<?> type) {
    Class<?> current = type;

    do {
        final Class<?>[] interfaces = current.getInterfaces();

        if (interfaces.length != 0) {
            return interfaces;
        }
    } while ((current = current.getSuperclass()) != Object.class);

    throw new UnsupportedOperationException("The type does not implement any interface");
}