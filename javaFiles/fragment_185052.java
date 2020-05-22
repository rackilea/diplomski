private static final Class<?> INIT_API_CLASS = loadClass(
        Item.class.getName()
);

private static Class<?> loadClass(String name) {
    try {
        return Class.forName(name, true, Accessor.class.getClassLoader()
        );
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
}