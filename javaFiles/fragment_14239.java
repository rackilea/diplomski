public Set<Class<?>> reflectPackage(String packageName) {
    final Set<Class<?>> classes = new HashSet<>();
    new FastClasspathScanner("your.package.name")
       .matchAllClasses(new ClassMatchProcessor() {

        @Override
        public void processMatch(Class<?> klass) {
            classes.add(klass);
        }
    }).scan();
    return classes;
}