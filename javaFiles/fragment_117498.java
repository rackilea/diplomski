private String findBeanClassName(Object beanRef) {
    return findBeanClass(beanRef).getSimpleName();
}

private Class<?> findBeanClass(Object beanRef) {
    return findAncestorWithAnnotation(beanRef.getClass(), Stateless.class);
}

private Class<?> findAncestorWithAnnotation(Class<?> cl, Class<? extends Annotation> annotation) {
    while ((cl != null) && !cl.isAnnotationPresent(annotation)) {
        cl = cl.getSuperclass();
    }
    return cl;
}