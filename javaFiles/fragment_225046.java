JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
int compilationResult = compiler.run(null, null, null, fileToCompile);
if (compilationResult == 0) {
    System.out.println("Compilation is successful");
} else {
    System.out.println("Compilation Failed");
}