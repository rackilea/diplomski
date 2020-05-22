public static class Init{
    private static ThreadLocal<WebDriver> WEBDRIVER = new ThreadLocal<WebDriver>();

   public static WebDriver getWebDriver(){
      WebDriver driver= WEBDRIVER.get();
      if (driver== null) {
        driver = new ChromeWebDriver();
        WEBDRIVER.set(driver);
      }
      return driver;
   }

   @AfterTest
   public void quit(){
      getWebDriver().quit();
  }
 }