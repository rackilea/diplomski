public class MyProcessor extends AbstractProcessor {

  public static @interface X { String value(); }

  @X("Hello") public static class Y {}

  @Override public boolean process(Set<? extends TypeElement> annotations,
      RoundEnvironment roundEnv) {
    for (Element element : roundEnv.getRootElements()) {
      X x = element.getAnnotation(X.class);
      if (x != null) System.out.println(x.value());
    }
    return true;
  }

  @Override public Set<String> getSupportedAnnotationTypes() {
    return new HashSet<String>(Arrays.asList(X.class.getCanonicalName()));
  }

  @Override public SourceVersion getSupportedSourceVersion() {
    return SourceVersion.RELEASE_6;
  }

  public static void main(String[] args) {
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    List<String> classes = Arrays.asList(Y.class.getCanonicalName());
    List<String> options = Arrays.asList("-processor", MyProcessor.class
        .getCanonicalName());
    CompilationTask task = compiler.getTask(null, null, null, options, classes,
        null);
    task.call();
  }
}