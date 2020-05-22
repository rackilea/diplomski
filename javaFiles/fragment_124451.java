for (Object annotated : context.getBeansWithAnnotation(ComponentScan.class).values()) {
    Class clazz = ClassUtils.getUserClass(annotated) // thank you jin!
    ComponentScan mergedAnnotation = AnnotatedElementUtils.getMergedAnnotation(clazz, ComponentScan.class);
    if (mergedAnnotation != null) { // For some reasons, this might still be null.
        // TODO: useful stuff.
    }
}