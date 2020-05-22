public Set<String> findAllPackages(String packagebase) {
List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
classLoadersList.add(ClasspathHelper.contextClassLoader());
classLoadersList.add(ClasspathHelper.staticClassLoader());
Reflections reflections = new Reflections(
        new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false),
                        new ResourcesScanner())
                .setUrls(
                        ClasspathHelper.forClassLoader(classLoadersList)))
                .filterInputsBy(
                        new FilterBuilder().include(FilterBuilder
                                .prefix(packagebase))));
Set<Class<? extends Object>> classes = reflections
        .getSubTypesOf(Object.class);
Set<String> packageNameSet = new TreeSet<String>();
for (Class classInstance : classes) {
    packageNameSet.add(classInstance.getPackage().getName());
}
return packageNameSet;}