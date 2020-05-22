public class DriverInit {

    public WebDriver driver;
    private static DriverInit driverInit = null;

    public static DriverInit getInstance() {
        if (driverInit == null) {
            driverInit = new DriverInit();
        }
        return driverInit;
    }

    private DriverInit() {
        this.driver = new FirefoxDriver();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get("******");
    }

    public WebDriver getDriver() {
        return this.driver;
    }