package Check;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

public class java2 {

    public static void main(String[] args) throws InterruptedException {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.youtube.com");
        Thread.sleep(2500);
        driver.findElement(By.xpath("//button[contains(.,'Sign in')]")).click();
        Thread.sleep(1500);
        driver.findElementById("Email").sendKeys("<User name>");
        driver.findElementById("Passwd").sendKeys("<Password>");
        driver.findElementById("signIn").click();
        Thread.sleep(4000);
        driver.findElementByCssSelector("div[id='identity-prompt-account-list'] > ul > label + label").click();
        driver.findElementById("identity-prompt-confirm-button").click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        int i =0;
        String CSSText = "ul[id='guide-channels'] > li";
        do {
            if (driver.findElementByCssSelector(CSSText).getText().equals("Josie Outlaw")){
                break;
            }
            CSSText = CSSText + " + li";
            i++;
        } while (i<35);
        js.executeScript("document.getElementsByClassName(\"vve-check overflowable-list-item guide-channel\")["+i+"].scrollIntoView(false);");
        Thread.sleep(1500);
        js.executeScript("document.getElementsByClassName(\"vve-check overflowable-list-item guide-channel\")["+i+"].scrollIntoView(true);");
        Thread.sleep(10000);
        driver.quit();
    }

}