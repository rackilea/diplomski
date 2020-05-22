public class myTest {

  private WebDriver driver;

  //This codes in BeforeTest below will initiate a new chrome driver session 
  @BeforeTest
  public void initiate() {
    System.setProperty("webdriver.chrome.driver", driverpathchrome);
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.BROWSER, Level.ALL);
    caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
    driver = new ChromeDriver(caps);

    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    driver.get("www.test.com");
    log.info("Chrome browser launched. Going to " + "www.test.com");
  }


  private boolean isBrowserOpen() {
    try {
      driver.getTitle();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public boolean amISeeingLoginScreenNow() {
    if (driver.findElements(By.cssSelector(".login-box.smaller")).size() != 0) {
      return true;
    } else {
      return false;
    }
  }

  //This is the test methods
  @Test(retryAnalyzer = myTest.RetryAnalyzer.class)
  private void loginToTestURL() throws Exception {

    //This will check if the current browser session is still open. If not, then create a new driver session
    if (this.isBrowserOpen() == false) {
      Thread.sleep(3000);

      // Initiating new Browser 
      this.initiate();
    } else {
      driver.get("www.test.com");
    }


    this.method_will_not_throw_exception() {
      //some codes that will work OK
    }


    try {
      this.method_will_throw_exception() {
        //some codes that will throw exception
        this.amISeeingLoginScreenNow(); //In the 2nd try , at this stage, Selenium will get grumpy
      }
    } catch (Exception e) {
      //put exception in the log files then re-throw the exception
      //retryAnalyzer will get the exception and then start the test from the start of @Test
      driver.quit();

      Thread.sleep(1000);
      this.initiate(); //re-initialise the new driver session before throwing exception to the retryAnalyzer

      throw new AssertionError();
    }

  }
}