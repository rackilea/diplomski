import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Spicejet_member_login {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.spicejet.com/");
        new Actions(driver).moveToElement(new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.link#ctl00_HyperLinkLogin")))).build().perform();
        new Actions(driver).moveToElement(new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='hide-mobile']/a[contains(.,'SpiceCash/SpiceClub Members')]")))).build().perform();
        new WebDriverWait(driver, 7).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='hide-mobile']//ul/li/a[@href='https://book.spicejet.com/Login.aspx' and contains(.,'Member Login')]"))).click();
    }
}