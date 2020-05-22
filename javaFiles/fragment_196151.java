public Method findMethodWithAnnotation(Class<?> clazz,
        Class<? extends Annotation> annotation) {

    if (clazz == Object.class || clazz == null) return null;
    for (Method m : clazz.getDeclaredMethods()) {
        if (m.isAnnotationPresent(annotation)) {
            return m;
        }
    }
    return findMethodWithAnnotation(clazz.getSuperClass(), annotation);
}