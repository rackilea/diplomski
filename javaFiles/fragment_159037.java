public class MyTest extends Selenide {

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests();
    private static WebDriver webDriver;

    @Before
    public void setupPage() {
        Configuration.reportsFolder = "build/reports/integrationTest/screenshots";
        Configuration.browser = WebDriverRunner.PHANTOMJS;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "assets/driver/phantomjs_mac");
        String[] phantomJsArgs = { "--ignore-ssl-errors=true" };
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_GHOSTDRIVER_CLI_ARGS, phantomJsArgs);
        caps.setCapability("takesScreenshot", true);
        webDriver = new PhantomJSDriver(caps);
        webDriver.manage().window().setSize(new Dimension(1280, 800));
        WebDriverRunner.setWebDriver(webDriver);
        open("file:///Users/UserName/Desktop/index.html");
    }

    @Test
    public void test() {
        WebElement text = webDriver.findElement(By.xpath("//div[@id='SubmitFormError']/p[2]/a"));

        System.out.println(text.getText());

    }
}