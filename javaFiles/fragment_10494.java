File helloWorldJava = new File(...);

DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

// This sets up the class path that the compiler will use.
// I've added the .jar file that contains the DoStuff interface within in it...
List<String> optionList = new ArrayList<String>();
optionList.add("-classpath");
optionList.add(System.getProperty("java.class.path"));

Iterable<? extends JavaFileObject> compilationUnit
        = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(helloWorldJava));
JavaCompiler.CompilationTask task = compiler.getTask(
    null, 
    fileManager, 
    diagnostics, 
    optionList, 
    null, 
    compilationUnit);
if (task.call()) {
    System.out.println("Yipe");
} else {
    // Opps compile failed...
    for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
        System.out.format("Error on line %d in %s%n",
                diagnostic.getLineNumber(),
                diagnostic.getSource().toUri());
    }
}
fileManager.close();