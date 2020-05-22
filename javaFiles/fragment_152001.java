CompilerOptions options = new CompilerOptions();
CompilationLevel.ADVANCED_OPTIMIZATIONS.setOptionsForCompilationLevel(options);
options.setCheckGlobalThisLevel(CheckLevel.OFF);
options.setOutputCharset("utf-8");
com.google.javascript.jscomp.Compiler compiler = new com.google.javascript.jscomp.Compiler(System.err);
compiler.disableThreads();
compiler.compile(SourceFile.fromFile(externsFile),
        SourceFile.fromFile(jsFile),
        options);
String result = compiler.toSource();
// TODO: write result to file