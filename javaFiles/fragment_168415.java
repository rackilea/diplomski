package SamplePrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSecondProgram {

/**
 * @param args
 */
public static void main(String[] args) throws Exception {
    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 100);

    driver.get("http://www.icicibank.com");
    wait.until(ExpectedConditions.titleContains("Personal Banking"));

    Actions hoverOps = new Actions(driver);
    hoverOps.moveToElement(driver.findElement(By.xpath(".//a[text()='Products']"))).build().perform();
    Thread.sleep(2000);
    hoverOps.moveToElement(driver.findElement(By.xpath(".//a[text()='Apply Online']"))).build().perform();
    Thread.sleep(2000);
    hoverOps.moveToElement(driver.findElement(By.xpath(".//a[text()='Payments']"))).build().perform();
    Thread.sleep(2000);
    hoverOps.moveToElement(driver.findElement(By.xpath(".//a[text()='Ways to Bank']"))).build().perform();
    Thread.sleep(2000);
    hoverOps.moveToElement(driver.findElement(By.xpath(".//a[text()='Find ATM Branch']"))).build().perform();
    Thread.sleep(2000);

    driver.quit();
}
}