public static Enum<?> getEnumFromMany(Collection<Class<?>> enums, String value) {
    for (Class<?> enumType : (Collection<Class<?>>) enums)
        if (enumType.isEnum()) {
            @SuppressWarnings("unchecked")
            Class<Enum<?>> clazz = (Class<Enum<?>>) enumType;
            for (Enum<?> en : clazz.getEnumConstants()) {
                if (en.name().equals(value))
                    return en;
            }
        }
    return null;
}