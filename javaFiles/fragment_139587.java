public class OtherClassSteps {

   private ContextSteps contextSteps;

   // PicoContainer injects class ContextSteps
   public OtherClassSteps (ContextSteps contextSteps) {
      this.contextSteps = contextSteps;
   }


   @Given("^Foo step$")
   public void fooStep() throws Throwable {
      // Access WebDriver instance
      WebDriver driver = contextSteps.getDriver();
   }
}