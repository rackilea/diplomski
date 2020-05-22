package com.qa.base;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Avanthi\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.abhibus.com/");


        driver.findElement(By.id("source")).sendKeys("Bang");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='ui-menu-item']//parent::li")));

        List<WebElement> list = driver.findElements(By.xpath("//li[@class='ui-menu-item']//parent::li"));

        System.out.println("Auto Suggest List ::" + list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());

            if (list.get(i).getText().equalsIgnoreCase("Bangalore Kempegowda Intl Airport")) {
                System.out.println(list.get(i).getText());
                list.get(i).click();
                break;
            }
        }

        try {
            driver.findElement(By.id("destination")).sendKeys("Chen");
            WebDriverWait wait1 = new WebDriverWait(driver, 60);
            wait1.until(ExpectedConditions
                    .visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='ui-menu-item']//parent::ul//following::ul//li")));
            List<WebElement> goingtolist = driver.findElements(By.xpath("//li[@class='ui-menu-item']//parent::ul//following::ul//li"));
            System.out.println("Auto Suggest List ::" + goingtolist.size());

            for (int i = 0; i < goingtolist.size(); i++) {
                System.out.println(goingtolist.get(i).getText());

                if (goingtolist.get(i).getText().equalsIgnoreCase("Chengannur Railway Station")) {
                    System.out.println(goingtolist.get(i).getText());
                    goingtolist.get(i).sendKeys(Keys.TAB);
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            System.out.println(e.getMessage());
        }

    }
}