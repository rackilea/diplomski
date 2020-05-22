public class MainBeforeAfter {

         public static WebDriver driver;
         public static  String testUrl = "http://www.urlhere.com";

    public static WebDriver getInstance()
    {
      if (System.getProperty("webdriver.chrome.driver") == null)
      {
        System.setProperty("webdriver.chrome.driver", "E:\\gita_workspace\\GitaProject\\drivers\\chromedriver.exe");
      }
      if (System.getProperty("test.url") != null)
      {
        testUrl = System.getProperty("test.url");
      }
      System.out.println(System.getProperty("webdriver.chrome.driver"));
      ChromeOptions options = new ChromeOptions();
      //options.addArguments("headless");
      options.addArguments("window-size=1200x600");
      return driver = new ChromeDriver(options);

    }
    @BeforeClass 
    public void beforeClass() throws InterruptedException
    {
     driver = MainBeforeAfter.getInstance();
      driver.get(testUrl);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();
     // enterLogin();
    }
    protected void enterLogin()
    {
      driver.findElement(By.name("username")).sendKeys("user");
      driver.findElement(By.name("password")).sendKeys("password");
      driver.findElement(By.name("password")).sendKeys(Keys.ENTER);

    }
    @AfterClass 
    public void afterClass() throws InterruptedException
    {
      driver.close();

      try
      {
        driver.quit();
      }
      catch (Exception e)
      {
        System.out.println("Unable to close browser after login header exception caught: " + e);
      }

    }

   }