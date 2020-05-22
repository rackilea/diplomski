public class TestBase {

    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.out.println("I am in setUp method.");

        //WebDriver instantiation etc.
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--disable-cache");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown(){
        System.out.println("I am in tearDown method.");

        //You can clean up after tests.
        driver.close();
    }
}