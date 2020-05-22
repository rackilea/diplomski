JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
int result = compiler.run(null, null, null, 
        "-d", outputDirectory, "-classpath", classPath, javaFilePath);
if(result == 0) {
    // compilation is successful
}