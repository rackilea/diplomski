public class CustomComputer extends Computer {

  private final List<Object> args;

  public CustomComputer(String[] args) {
      this.args = Arrays.<Object>asList(args);
  }

  @Override
  protected Runner getRunner(RunnerBuilder builder, final Class<?> testClass) throws Throwable {
      if (testClass.isAnnotationPresent(Test.CustomParameterized.class)) {
          final BlockJUnit4ClassRunnerWithParametersFactory factory = new BlockJUnit4ClassRunnerWithParametersFactory();
          return new CustomParameterizedRunner(testClass, factory);
      }
      return builder.runnerForClass(testClass);
  }

  private class CustomParameterizedRunner extends Suite {
      private final Class<?> testClass;
      private final BlockJUnit4ClassRunnerWithParametersFactory factory;

      public CustomParameterizedRunner(Class<?> testClass, BlockJUnit4ClassRunnerWithParametersFactory factory) throws InitializationError {
          super(testClass, Collections.EMPTY_LIST);
          this.testClass = testClass;
          this.factory = factory;
      }

      @Override
      protected List<Runner> getChildren() {
          List<Runner> runners = new ArrayList<>();
          for (Object arg : args) {
              runners.add(runnerFor(arg, testClass, factory));
          }
          return runners;
      }
  }


  private static Runner runnerFor(Object arg, Class<?> testClass, BlockJUnit4ClassRunnerWithParametersFactory factory) {
      ArrayList<Object> parameters = new ArrayList<>(1);
      parameters.add(arg);
      String name = testClass.getSimpleName() + "[" + arg + "]";
      TestWithParameters test = new TestWithParameters(name, new TestClass(testClass), parameters);
      try {
        return factory.createRunnerForTestWithParameters(test);
      } catch (InitializationError initializationError) {
        throw new RuntimeException(initializationError);
      }
  }
}