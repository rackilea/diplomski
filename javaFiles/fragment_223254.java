public static Object readProperty(String name, Object object) throws Exception {
    Class<?> clazz = object.getClass();
    do {
        try {
            Field field = clazz.getDeclaredField(name);
            return field.get(object);
        } catch (NoSuchFieldException e) {
            clazz = clazz.getSuperclass();
        }
    } while (clazz != null);
    return null;
}