private static Map<Class<? extends AbstractClass>, Map<String, AbstractClass>> map = new HashMap<>();

private static synchronized Map<Class<? extends AbstractClass>, Map<String, AbstractClass>> getNameMap(Class<T> clazz) {
    // same as before
}

public static <T extends AbstractClass> T valueOf(Class<T> clazz, String name) {
    return clazz.cast(getNameMap(clazz).get(name));
}