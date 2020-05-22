Predicate<String> filter = new FilterBuilder().include(".*\\.properties");
    Reflections reflections = new Reflections(new ConfigurationBuilder()
            .filterInputsBy(filter)
            .setScanners(new ResourcesScanner())
            .setUrls(asList(ClasspathHelper.forJavaClassPath())));
    System.out.println(reflections.getStore().get(ResourcesScanner.class).keySet());