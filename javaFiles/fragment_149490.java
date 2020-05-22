@Test
   public void runAnnoationProcessor() throws Exception {
      String source = "my.project/src";

      Iterable<JavaFileObject> files = getSourceFiles(source);

      JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

      CompilationTask task = compiler.getTask(new PrintWriter(System.out), null, null, null, null, files);
      task.setProcessors(Arrays.asList(new MyAnnotationProcessorClass()));

      task.call();
   }

   private Iterable<JavaFileObject> getSourceFiles(String p_path) throws Exception {
     JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
     StandardJavaFileManager files = compiler.getStandardFileManager(null, null, null);

     files.setLocation(StandardLocation.SOURCE_PATH, Arrays.asList(new File(p_path)));

     Set<Kind> fileKinds = Collections.singleton(Kind.SOURCE);
     return files.list(StandardLocation.SOURCE_PATH, "", fileKinds, true);
   }