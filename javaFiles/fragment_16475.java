Object convertStringToActualType(String arg, Class<?> type) {
    if (type == String.class)
        return arg;
    if (type == Boolean.class)
        return Boolean.valueOf(arg);
    throw new IllegalArgumentException("type " + type.getSimpleName() + " not supported");
}