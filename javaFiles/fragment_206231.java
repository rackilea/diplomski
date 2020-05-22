package com.example;

import java.io.File;
import java.io.IOException;
import javax.tools.*;
import java.util.Collections;

public class Compiler {
    public static void main(String[] args) throws IOException {

        // source file
        String[] filesToCompile = { "/path/to/input/Test.java" };

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

        // output path
        fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Collections.singleton(new File("/tmp")));

        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjects(filesToCompile);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null,null, null, compilationUnits);
        boolean success = task.call();
        System.out.println(success);
   }
}