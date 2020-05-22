private Field getField(Class<?> clazz, String p) {
    return Arrays.stream(clazz.getDeclaredFields())
            .filter(f -> p.equals(f.getName()))
            .findFirst()
            .orElseGet(() -> getField(clazz.getSuperclass(), p));
}