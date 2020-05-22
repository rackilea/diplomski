public class DriverInit {

    private AndroidDriver<WebElement> driver;

    private static DriverInit driverInit = null;

    public static DriverInit getInstance() {
        if (driverInit == null) {
            driverInit = new DriverInit();
        }
        return driverInit;
    }

    private DriverInit() {
         DesiredCapabilities capability = new DesiredCapabilities();

         capability.setCapability("deviceName", "Android");
         capability.setCapability("platformName", "Android");
         capability.setCapability("platformVersion", "5.1.1");
         capability.setCapability("deviceName", "Samsung Galaxy On5");
         capability.setCapability("app", "D:\\whatsapp.apk");
         capability.setCapability("PackageName",  "com.movocado.socialbostonsports");
         capability.setCapability("ActivityName", "com.movocado.socialbostonsports.Activity.LogInSceen");


         this.driver = new AndroidDriver<WebElement>(new URL(
                "http://127.0.0.1:4723/wd/hub"), capability);

         this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}