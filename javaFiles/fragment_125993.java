public class FilterRunner extends BlockJUnit4ClassRunner {
  private List<String> testsToRun = Arrays.asList(new String[] { "test1" });

  public FilterRunner(Class<?> klass) throws InitializationError {
    super(klass);
  }

  @Override
  protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
    Description description= describeChild(method);
    if (method.getAnnotation(Ignore.class) != null || !testsToRun.contains(method.getName())) {
      notifier.fireTestIgnored(description);
    } else {
      runLeaf(methodBlock(method), description, notifier);
    }
  }
}