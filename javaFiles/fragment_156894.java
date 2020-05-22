for (Field f : getClass().getDeclaredFields()) {
    if (Modifier.isStatic(f.getModifiers()) continue;
    if (!f.isAccessible()) {
        f.setAccessible(true);
    }
    Object value = f.get(this);
    temp += ", " + f.getName() + ": " + String.valueOf(value);
}