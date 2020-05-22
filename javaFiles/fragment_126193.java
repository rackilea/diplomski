Package Name = com.main
Class Name = MainClass.java
Source Dir = src

public  void compileClass() {
        System.setProperty("java.home", "G:\\Java\\Tools\\installed\\JDK");   // Set JDK path it will help to get compiler
        File root = new File("/src");   // Source Directory 
        File sourceFile = new File(root, "com/main/MainClass.java");    // Java file name with package 
        sourceFile.getParentFile().mkdirs();
        try {
            new FileWriter(sourceFile).close();  // Read Java file
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler.run(null, null, null, sourceFile.getPath()));
    }