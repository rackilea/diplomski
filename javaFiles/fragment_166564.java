ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
// Use names and ensure unique to protect against duplicates
Set<String> names = new LinkedHashSet<String>(
                SpringFactoriesLoader.loadFactoryNames(type, classLoader));
List<T> instances = createSpringFactoriesInstances(type, parameterTypes,
                classLoader, args, names);