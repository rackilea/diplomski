public class NiceExceptions implements TestRule {
  public Statement apply(final Statement base, final Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        try {
          base.evaluate();
        } catch (AssumptionViolatedException e) {
          throw e;
        } catch (Throwable t) {
          throw new YourNiceException(t);
        }
      }
    };
  }
}

public class YourTest {
  @Rule
  public final TestRule niceExceptions = new NiceExceptions();

  @Test
  public void yourTest() {
    ...
  }
}