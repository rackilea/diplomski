public class ExtraSetupTest {
  @Rule
  public TestRule moreSetup = new TestRule() {
    public Statement apply(Statement base, Description description) {
      return statement(base, description);
    }

    private Statement statement(final Statement base,
        final Description description) {
      return new Statement() {
        @Override
        public void evaluate() throws Throwable {
          if (description.getAnnotation(Deprecated.class) != null) {
            System.out.println("more setup here");
          }
          base.evaluate();
        }
      };
    }
  };

  @Test
  public void noExtraSetup() {
    System.out.println("noExtraSetup");
  }

  @Test
  @Deprecated
  public void withExtraSetup() {
    System.out.println("withExtraSetup");
  }
}