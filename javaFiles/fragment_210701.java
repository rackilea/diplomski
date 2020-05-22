@SuppressWarnings("unchecked")
public static <E> E get(Object object, String fieldName) {
    Class<?> clazz = object.getClass();
    while (clazz != null) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (E) field.get(object);
        } catch (NoSuchFieldException e) {
            clazz = clazz.getSuperclass();
        } catch (Exception e) {
            return null;
        }
    }
    return null;
}