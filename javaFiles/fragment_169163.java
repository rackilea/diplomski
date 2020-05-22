import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestMain {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\tests\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1024,768");

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        WebDriver driver = new ChromeDriver(capabilities);

        driver.get("http://google.com/");

        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("document.getElementsByClassName(\"gb_we\")[0].click()");
        }

    WebElement fName=driver.findElement(By.id("identifierId"));
    fName.sendKeys("test@gmail.com");

    WebElement btnNext =driver.findElement(By.id("identifierNext"));
    btnNext.click();

    }
}