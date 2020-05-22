public class SettingsClass {

    public WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "chromeDriver_path");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "chrome.switches", "--disable-extensions");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies(); // delete all cookies
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }
}