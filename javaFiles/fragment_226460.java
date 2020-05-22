final String className = MyClass.class.getCanonicalName();
    final Predicate<String> filter = new Predicate<String>() {
        public boolean apply(String arg0) {
            return arg0.startsWith(className);
        }
    };

    Reflections reflections = new Reflections(
            new ConfigurationBuilder()
            .setUrls(ClasspathHelper.forClass(MyClass.class))
            .filterInputsBy(filter)
            .setScanners(new MethodAnnotationsScanner()));

    Set<Method> resources =
            reflections.getMethodsAnnotatedWith(org.testng.annotations.Test.class);