import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserDriverFactory {

  public static WebDriver createDriver(String browser) {
    System.err.println("Create driver: " + browser);

    if (browser.equals("chrome")) {
      System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
      return new ChromeDriver();
    } else if (browser.equals("firefox")) {
      System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
      FirefoxOptions options = new FirefoxOptions();
      FirefoxProfile profile = new FirefoxProfile();
      profile.setPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream");
      options.setProfile(profile);
      return new FirefoxDriver(options);
    }
    System.out.println("Do not know how to start: " + browser + ", starting chrome.");
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    return new ChromeDriver();
  }
}