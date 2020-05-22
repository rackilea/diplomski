public class FirefoxProfile_opt {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile testprofile = profile.getProfile("Abhi_Selenium");
        FirefoxOptions opt = new FirefoxOptions();
        opt.setProfile(testprofile);
        WebDriver driver =  new FirefoxDriver(opt);
        driver.get("https://www.google.com");
    }
}