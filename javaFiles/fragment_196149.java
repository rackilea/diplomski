public Method findMethodWithAnnotation(Class<?> clazz,
        Class<? extends Annotation> annotation) {
    for (Method m : clazz.getDeclaredMethods()) {
        if (m.isAnnotationPresent(annotation)) {
            return m;
        }
    }
    return null;
}