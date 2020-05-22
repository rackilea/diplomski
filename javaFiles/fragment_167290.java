public class CallUrl {
    WebDriver driver;

    @BeforeClass
    public void openBrowser() throws IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("chrome.switches", "--disable-extensions");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void openURL() throws IOException {
        driver.get("http://newtours.demoaut.com/");
        WebDriverWait myDynamicElement = new WebDriverWait(driver, 30);
        myDynamicElement.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='userName']")));
    }

    @Test (dependsOnMethods = "openURL")
    public void loginToTours() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='userName']")).click();
    }

}