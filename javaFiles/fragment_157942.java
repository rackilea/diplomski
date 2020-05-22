public class Browser {

 private static WebDriver driver;
 LoanDetails objLoan = new LoanDetails();

   @BeforeMethod
   @Parameters("Browser")
   public  void beforeTestUtility(String browser) throws Exception {
        objLoan.commonMethod(browser);
   }

   @Test
   public static WebDriver  GetBrowser(String Browser) 
   {
    if (driver != null) 

        return driver;


        else if (Browser.equalsIgnoreCase("Firefox")) {
              Log.info("Driver Initiated");
              System.setProperty("webdriver.firefox.driver", Constants.geckodriver);
              driver = new FirefoxDriver();
              driver.get(Constants.URL);
              Log.info("Application Opening");
              driver.manage().window().maximize();
              return driver;
        }

              else if (Browser.equalsIgnoreCase("Chrome")) {
                  Log.info("Driver Initiated");
                  System.setProperty("webdriver.chrome.driver", Constants.chromedriver);
                  driver = new ChromeDriver();
                  driver.get(Constants.URL);
                  Log.info("Application Opening");
                  driver.manage().window().maximize();

                  return driver;
              }                    
   return driver;                    
   }   
}