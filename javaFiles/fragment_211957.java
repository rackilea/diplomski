public static <T> T staticCast(Object arg, Class<T> clazz) {
    if (arg == null) return null;
    if (!clazz.isInstance(arg))
        return null;
    T result = clazz.cast(arg);
    return result;
}