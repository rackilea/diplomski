public class LoginCheck {

    public WebDriver driver;
    private CommonMethods cm;
    private LoginPage lp;

    @BeforeClass
    public void beforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/himanshu/Downloads/chromedriver_linux64/chromedriver");
        driver= new ChromeDriver();
        cm = new CommonMethods(driver);
        lp = new LoginPage(driver);
    }

    @Test
    public void checkLoginFunctionality() {
        lp.loginWithCustomer();
    }

    @AfterMethod
    public void Screenshot(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE) {
             TakesScreenshot ss= (TakesScreenshot)driver;
             File screenshotfile = ss.getScreenshotAs(OutputType.FILE);
             FileUtils.copyFile(screenshotfile, new File("./Screenshots/"+result.getName()+".png"));
        }
    }

      @AfterClass
      public void afterClass() {
          driver.close();
      }
    }