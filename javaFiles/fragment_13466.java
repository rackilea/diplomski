import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.Test;

public class A_FirefoxProfile {

      @Test
      public void seleniumFirefox() {
        System.setProperty("webdriver.gecko.driver", "C:/Utility/BrowserDrivers/geckodriver.exe");
        ProfilesIni profileIni = new ProfilesIni();
        FirefoxProfile profile = profileIni.getProfile("default");
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        WebDriver driver = new FirefoxDriver(options);
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
      }

}