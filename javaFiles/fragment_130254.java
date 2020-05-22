File[] files = new File[]{new File("/path/to/source/MyTests.java")};

JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

String classPath = System.getProperty("java.class.path");
String testpath = classPath + ";/path/to/lib/junit-4.10.jar";

List<String> options = new ArrayList<>();
options.addAll(Arrays.asList("-classpath", testpath));

try (StandardJavaFileManager filemanager = compiler.getStandardFileManager(
        null, null, null)) {
    Iterable fileObjects = filemanager.getJavaFileObjects(files);
    JavaCompiler.CompilationTask task = compiler.getTask(
            null, null, null, options, null, fileObjects);
    task.call();
}