package de.scrum_master.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Interactions {
  public static void touchWebElement(WebElement element, WebDriver driver) {}

  public static void touchWebElement(By by, WebDriver driver) {
    // Works
    WebElement webElement = driver.findElement(by);
    touchWebElement(webElement, driver);
    // Works
    touchWebElement((WebElement) driver.findElement(by), driver);
    // Ambiguous due to type erasure -> does not work
    touchWebElement(driver.findElement(by), driver);
  }
}