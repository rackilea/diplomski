PrintWriter writer = new PrintWriter(System.out);
JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

Iterable<? extends JavaFileObject> units =
    fileManager.getJavaFileObjectsFromFiles(
        Arrays.asList(new File("Hello.java"))); // put absolute path here

JavaCompiler.CompilationTask task = compiler.getTask(
    writer, fileManager, null, null, null, units); // provide units, not classes
task.call();

fileManager.close();