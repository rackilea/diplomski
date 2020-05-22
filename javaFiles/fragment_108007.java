public static <T extends Enum<T> & WithKeyEnum> T getByKey(Class<T> enumTypeClass, String key) {
    for (T type : enumTypeClass.getEnumConstants()) {
        if (type.getKey().equals(key)) {
            return type;
        }
    }
    throw new IllegalArgumentException();
}