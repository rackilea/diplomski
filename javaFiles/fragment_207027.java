public static interface Fields<T extends Enum<T> & Fields<T, D, K>, D extends Data, K> {
    // ....

    GetEntries<K, T> selectStrategy();
}

private static <K, T extends Enum<T> & Fields<T, ?, K>>
GetEntries<K, T> selectStrategy(Class<T> fields) {
    for (T field : fields.getEnumConstants()) {
        return field.selectStrategy();
    }
    throw new IllegalArgumentException("Enum type has no instances: " + fields);
}