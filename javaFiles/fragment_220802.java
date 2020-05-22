public static boolean isInstance(final Object value, final Type type) {
    if (type == null) {
        return false;
    }

    return value == null ? !(type instanceof Class<?>) || !((Class<?>) type).isPrimitive()
            : isAssignable(value.getClass(), type, null);
}