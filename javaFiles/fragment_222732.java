public class VariantOne implements ITestCaseConfiguration {

  @Override
  public void setup() {
    System.err.println("setup() from VariantOne");
  }

  @Override
  public void tearDown() {
    System.err.println("tearDown() from VariantOne");
  }
}