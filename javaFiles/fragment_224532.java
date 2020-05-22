static <T extends Enum<T>> T getEnumOrNull(Class<T> enumType, String name) {
    try {
        return Enum.valueOf(enumType, name);
    } catch (IllegalArgumentException e) {
        return null;
    }
}