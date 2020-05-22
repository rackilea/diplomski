public class CalculatorSteps {
  private RequiresSetupCalculator calculator;

  @Before
  public void setUp() {
    calculator = RequiresSetupCalculator.setup();
    System.out.println("Setup Performed...");
  }

  ... (existing test steps unchanged)...

  @After
  public void cleanUp() {
    System.out.println("CleanUp Performed...");
    calculator.cleanUp();
  }
}