Map<String, Object> beans = appContext.getBeansWithAnnotation(RestController.class);
for (Map.Entry<String, Object> entry : beans.entrySet()) {
    Class clazz = AopProxyUtils. AopProxyUtils.ultimateTargetClass(entry.getValue());
    ReflectionUtils.doWithMethods(clazz, new MethodCallback() {
        public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
            Annotation[] annotations = AnnotationUtils.getAnnotations(method);
            for(Annotation annotation : annotations) {
                LOG.debug("Annotation: " + annotation);
            }
        }
    });
}