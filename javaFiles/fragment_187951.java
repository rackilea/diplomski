public static List<Class<?>> getClassesAnnotatedWith(Class annotation, ServletContext servletContext) {
    List<Class<?>> webClasses, jarClasses;
    webClasses= getClassesAnnotedWithFromClassLoader(annotation, servletContext.getClassLoader());
    jarClasses= getClassesAnnotedWithFromClassLoader(annotation, Thread.currentThread().getContextClassLoader());
    for (Class<?> jarClass : jarClasses) {
        Class<?> elementToAdd= null;
        for (Class<?> webClass : webClasses) {
            if ( ! jarClass.getName().equals(webClass.getName())) {
                elementToAdd= jarClass;
            }
        }
        if(elementToAdd != null) {
            webClasses.add(elementToAdd);
        }
    }
    return webClasses;
}


 private static List<Class<?>> getClassesAnnotedWithFromClassLoader(Class annotation, ClassLoader classLoader) {
        List<Class<?>> classes= new ArrayList<Class<?>>();
        Class<?> classLoaderClass= classLoader.getClass();
        while (! classLoaderClass.getName().equals("java.lang.ClassLoader")) {
            classLoaderClass= classLoaderClass.getSuperclass();
        }
        try {
            Field fldClasses= classLoaderClass.getDeclaredField("classes");
            fldClasses.setAccessible(true);
            Vector<Class<?>> classesVector= (Vector<Class<?>>) fldClasses.get(classLoader);
            for (Class c : classesVector) {
                if (c.isAnnotationPresent(annotation)) {
                    classes.add(c);
                }
            }
        } catch (Exception e) { }
        return classes;
    }