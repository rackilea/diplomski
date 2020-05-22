JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

// The convertToPath method just returns "src/main/java/<pathWithSlashes>.java"
Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(
    new File("ActualProject/" + convertToPath(element.getQualifiedName().toString())));

// The boolean here defines whether the last separator char should be cut off.
// We need to expand the class path so we might as well leave it there.
String classpath = getCurrentClasspath(false) +
    new File("Annotations/target/Annotations-version.jar").getAbsolutePath();

File outputDir = new File("ActualProject/target/classes/");
Iterable<String> arguments = Arrays.asList("-proc:none",
    "-d", outputDir.getAbsolutePath(),
    "-classpath", classpath);

boolean success = compiler.getTask(null, fileManager, null, arguments, null, compilationUnits).call();

fileManager.close();