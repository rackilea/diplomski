private static Field getDeclaredFieldInHierarchy(Class<?> clazz, String fieldName) {
    if (clazz == null) {
        return null;
    }
    try {
        return clazz.getDeclaredField(fieldName);
    } catch (NoSuchFieldException e) {
        return getDeclaredFieldInHierarchy(clazz.getSuperclass(), fieldName);
    }
}