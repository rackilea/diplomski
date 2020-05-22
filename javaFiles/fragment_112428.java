public String compile(String source, Object... options) {
    String className = getMainClassName(source);

    if (className == null) {
        throw new WrongSourceStructureException("No public class which implements 'Solution'");
    }

    javax.tools.JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    if (compiler == null)
        throw new BadEnvironmentException("You should specify path to JDK in your JDK_HOME and JAVA_HOME");

    Writer err = new StringWriter();
    DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
    List<String> compilerOptions = new ArrayList<String>();

    String[] opts = new String[options.length - 1];
    System.arraycopy(options, 1, opts, 0, opts.length);

    if (options != null) {
        compilerOptions.addAll(Arrays.asList(opts));
    }

    compilerOptions.add("-d");
    compilerOptions.add("./tmp/classes/");

    JavaFileObject codeSolution = new JavaSourceFromString(className, source);

    Iterable<? extends JavaFileObject> units = Arrays.asList(codeSolution);
    javax.tools.JavaCompiler.CompilationTask task = compiler.getTask(err, null, diagnostics, compilerOptions, null, units);

    boolean success = task.call();

    if (!success) {
        StringBuilder errorMessages = new StringBuilder();
        for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
            errorMessages.append(diagnostic.getMessage(null)).append("\n");
        }
        throw new NotCompiledException(errorMessages.toString());
    }

    String aPackage = getPackage(source);

    return ".tmp/classes/" + options[0] + aPackage.replace(".", "/") + "/" + className + ".class";
}