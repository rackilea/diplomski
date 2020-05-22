/** Create one test method that will be invoked by TestNG and invoke the 
 * Cucumber runner within that method.
 */
  @CucumberOptions(plugin = "json:target/cucumber-report-composite.json")
    public class RunCukesByCompositionTest {

    @Test(groups = "examples", description = "Example of using TestNGCucumberRunner to invoke Cucumber")
    public void runCukes() {
        new TestNGCucumberRunner(getClass()).runCukes();
    }
}