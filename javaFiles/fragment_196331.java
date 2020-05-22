import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Configurations {

    public WebDriver driver;

    public void testConfiguration() {
        driver = new FirefoxDriver();
    }
}