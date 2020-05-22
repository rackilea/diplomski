public static <T> T copyTo(Object from, T to) {
    for(Method m : to.getClass().getMethods()) {
        if (!m.getName().startsWith("set") || m.getParameterCount() != 1)
            continue;
        try {
            Method getter = from.getClass().getMethod("g" + m.getName().substring(1));
            m.invoke(to, getter.invoke(from));
        } catch (NoSuchMethodException ignored) {
            // ignored
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
    return to;
}