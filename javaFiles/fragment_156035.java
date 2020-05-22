public static ClassLoader getClassLoader(MavenProject project) throws DependencyResolutionRequiredException, MalformedURLException {
    List<String> classPathElements = compileClassPathElements(project);
    List<URL> classpathElementUrls = new ArrayList<>(classPathElements.size());
    for (String classPathElement : classPathElements) {
        classpathElementUrls.add(new File(classPathElement).toURI().toURL());
    }
    return new URLClassLoader(
        classpathElementUrls.toArray(new URL[classpathElementUrls.size()]),
        Thread.currentThread().getContextClassLoader()
    );
}

private static List<String> compileClassPathElements(MavenProject project) throws DependencyResolutionRequiredException {
    return newArrayList(project.getCompileClasspathElements());
}