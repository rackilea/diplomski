static <T> Object[] getFieldValues(final Class<T> type, final T instance) {

    final Field[] fields = type.getDeclaredFields(); // includes private fields

    final Object[] values = new Object[fields.length];

    for (int i = 0; i < fields.length; i++) {
        if (!fields[i].isAccessible()) {
            fields[i].setAccessible(true); // enables private field accessing.
        }
        try {
            values[i] = fields[i].get(instance);
        } catch (IllegalAccessException iae) {
            // @@?
        }
    }

    return values;
}