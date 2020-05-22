public class LaunchApp {

        AndroidDriver<WebElement> driver;

        @BeforeTest
        public void Test1() throws MalformedURLException {
            driver = DriverInit.getInstance().getDriver();
            //now do your stuff with this driver
        }
  }