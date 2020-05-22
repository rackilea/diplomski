package demo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Q45402867_tagname_a {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","C:\\Utility\\BrowserDrivers\\geckodriver.exe");  
        WebDriver driver=new FirefoxDriver();
        String baseUrl="https://www.udacity.com/";
        driver.get(baseUrl);
        String Title="Udacity - Free Online Courses and Nanodegree Programs";
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        System.out.println(linkElements.size());
        for (WebElement ele:linkElements)
        System.out.println(ele);
    }

}