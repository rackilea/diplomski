public static void runAllAnnotatedWith(Class<? extends Annotation> annotation)
                                                               throws Exception {
    Reflections reflections = new Reflections(new ConfigurationBuilder()
                                  .setUrls(ClasspathHelper.forJavaClassPath())
                                  .setScanners(new MethodAnnotationsScanner()));
    Set<Method> methods = reflections.getMethodsAnnotatedWith(annotation);

    for (Method m : methods) {
        // for simplicity, invokes methods as static without parameters
        m.invoke(null); 
    }
}