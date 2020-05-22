package com.logansnow.marketwatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args){

        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);

        WebDriver driver = new HtmlUnitDriver();
        driver.get("https://id.marketwatch.com/access/50eb2d087826a77e5d000001/latest/login_standalone.html?url=http%3A%2F%2Fwww.marketwatch.com%2Fuser%2Flogin%2Fstatus");
        WebElement email = driver.findElement(By.name("username"));
        WebElement loginPass = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.id("submitButton"));
        email.sendKeys("***********@gmail.com");
        loginPass.sendKeys("******************");
        //loginPass.submit();

        // Click on the submit button to submit the form.
        driver.findElement(By.className("login_submit")).click();

        // Can also use this since you already have WebElement referencing the submit button.
        // button.click();

        // Or invoke submit on the button element
        // button.submit();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.getTitle());
    }
}