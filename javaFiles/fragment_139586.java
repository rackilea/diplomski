public class ContextSteps {

   private static boolean initialized = false;

   private WebDriver driver;

   @Before
   public void setUp() throws Exception {
      if (!initialized) {
         // initialize the driver
         driver = = new FirefoxDriver();

         initialized = true;
      }
   }

   public WebDriver getDriver() {
      return driver;
   }
}