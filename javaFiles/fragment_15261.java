package testpkg;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class loginTest {
WebDriver driver;
Logger log = Logger.getLogger(loginTest.class.getName());

  @BeforeMethod
  public void setUp() {
        //System.setProperty("webdriver.chrome.driver" , "C:/Users/User/Desktop/Selenium Drivers/chromedriver.exe");
      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "\\Executables\\Chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        log.debug("opening webiste");
    }

  @Test
  public void titleTest() {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Google");
        log.debug("Title match");
    }

  @Test
  public void gmailLogoTest() {
        boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
        Assert.assertTrue(true);
        log.debug("Linked found");

    }

  @AfterMethod
  public void tearDown() {
        driver.quit();


    }

}