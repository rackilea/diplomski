public class FirefoxProfile_dc_opt {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile testprofile = profile.getProfile("Abhi_Selenium");
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setCapability(FirefoxDriver.PROFILE, testprofile);
        FirefoxOptions opt = new FirefoxOptions();
        opt.merge(dc);
        WebDriver driver =  new FirefoxDriver(opt);
        driver.get("https://www.google.com");
    }
}