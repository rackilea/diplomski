/**
 * Returns explicit serial version UID value declared by given class, or
 * null if none.
 */
private static Long getDeclaredSUID(Class<?> cl) {
    try {
        Field f = cl.getDeclaredField("serialVersionUID");
        int mask = Modifier.STATIC | Modifier.FINAL;
        if ((f.getModifiers() & mask) == mask) {
            f.setAccessible(true);
            return Long.valueOf(f.getLong(null));
        }
    } catch (Exception ex) {
    }
    return null;
}