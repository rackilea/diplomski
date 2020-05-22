try {
        StandardJavaFileManager standardJavaFileManager = 
                   compiler.getStandardFileManager(null, null, null);
        standardJavaFileManager.setLocation(StandardLocation.CLASS_PATH, 
                   listFilePaths(folder, context));
        File[] javaFiles = new File[] { javaFile.toFile(), 
        Paths.get("/tmp/JUnitTest.java").toFile() };

        Iterable<? extends JavaFileObject> compilationUnits1 = 
                 standardJavaFileManager
                .getJavaFileObjectsFromFiles(Arrays.asList(javaFiles));
        CompilationTask task = compiler.getTask(null, standardJavaFileManager, null, 
                 optionList, null,
                 compilationUnits1);
        task.call();
       } catch (Exception e) {
           context.getLogger().log("Exception " + e + "\n");
       }