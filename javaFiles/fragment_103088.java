import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RandomNumbers_GoogleSearchBox {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.name("q"))).sendKeys(UUID.randomUUID().toString());
    }
}