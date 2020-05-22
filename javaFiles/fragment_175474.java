JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

DiagnosticCollector<JavaFileObject> diagnostics = 
    new DiagnosticCollector<JavaFileObject>();         
StandardJavaFileManager fileManager = compiler.
    getStandardFileManager(diagnostics, null, null);

Iterable<? extends JavaFileObject> compilationUnits = fileManager.
    getJavaFileObjectsFromFiles(Arrays.asList(new File("Test.java")));
CompilationTask task = compiler.getTask(null, fileManager, diagnostics, 
    null, null, compilationUnits);

task.call();

for(Diagnostic<?> error : diagnostics.getDiagnostics()) {
    // 
}