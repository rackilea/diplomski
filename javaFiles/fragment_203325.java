JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);
Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromStrings(Arrays.asList("YouFileToCompile.java"));
JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, null,
        null, compilationUnits);
boolean success = task.call();
fileManager.close();