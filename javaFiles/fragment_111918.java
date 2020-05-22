for (Class<Object> clazz : getClasses(packageName)) {
  cfg.addAnnotatedClass(clazz);
}

private List<Class> getClasses(String packageName) throws ClassNotFoundException {
    List<Class> classes = new ArrayList<>();

    ClassLoader cld = Thread.currentThread().getContextClassLoader();

    String path = packageName.replace('.', '/');
    URL resource = cld.getResource(path);

    File directory = new File(resource.getFile());

    if (!directory.exists()) {
        throw new ClassNotFoundException(packageName + " is not a valid package");
    }
    processDirectory(packageName, classes, directory);

    return classes;
}