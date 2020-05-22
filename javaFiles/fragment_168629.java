package testing.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {
    public static WebDriver driver;

    public static void main(String[] args) {

        getWebDriver();
        String xpathValues= "//div[@class='FPdoLc VlcLAe']//input[@name='btnK']";
        Method m1 = new Method(driver);
        m1.clickByXpath(xpathValues);

    }

    public static void getWebDriver() {
        System.setProperty("webdriver.chrome.driver", "Your chrome driver path");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

}