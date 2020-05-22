package demo; //replace by your own package name

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class A_Chrome_Options_test {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Utility\\BrowserDrivers\\chromedriver.exe");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setJavascriptEnabled(true);
        ChromeOptions opt = new ChromeOptions();
        opt.merge(cap);
        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}