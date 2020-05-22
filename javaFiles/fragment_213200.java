public static <T> T castClass(Object o, Class<T> c) {
    try {
        return c.cast(o);
    } catch (ClassCastException e) {
        e.getMessage();
    }
    return null;
}