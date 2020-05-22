public static void setInternalState(Object target, String field, Object value) {
    Class<?> c = target.getClass();
    try {
        Field f = getFieldFromHierarchy(c, field);  // Checks superclasses.
        f.setAccessible(true);
        f.set(target, value);
    } catch (Exception e) {
        throw new RuntimeException(
            "Unable to set internal state on a private field. [...]", e);
    }
}