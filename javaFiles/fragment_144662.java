public class StepDefs {
  private Scenario scenario;

  /* Need to capture the scenario object in the instance to access it
   * in the step definition methods. */
  @Before
  public void before(Scenario scenario) {
    this.scenario = scenario;
  }

  @Given("^I do a step$")
  public void iDoAStep() {
    scenario.write("This text is output with scenario.write");
  }
}