static Class<?> mostSpecificCommonSuperclass(Class<?> a, Class<?> b) {
    Class<?> s = a;
    while (!s.isAssignableFrom(b)) {
        s = s.getSuperclass());
    }
    return s;
}