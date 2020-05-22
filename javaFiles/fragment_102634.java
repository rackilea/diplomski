import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.*;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;



DesiredCapabilities capability =  DesiredCapabilities.android();

      capability.setCapability("BROWSER_NAME", "Android");

      capability.setCapability("VERSION", "7.0");

      capability.setCapability("platformName", "Android");

      capability.setCapability("appPackage", "your.app.package");

          capability.setCapability("appActivity", "your.app.activity");


          capability.setCapability("deviceName", "ec8d4453");

nodeURL= "http://localhost:4723/wd/hub" ;

driver = new AndroidDriver(new URL(nodeURL), capability);

TouchAction  touchAction = new TouchAction(driver);

WebElement allow= driver.findElementByAndroidUIAutomator(

"new UiSelector().className(\"android.widget.Button\").text(\"ALLOW\")"

);

touchAction.press(allow).release().perform().press(allow).release().perform();