package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Q44308973_remote_unreachablebrowserexception {

public static void main(String[] args) 
{

System.setProperty("webdriver.gecko.driver", "C:\\your_directory\\geckodriver.exe");
DesiredCapabilities dc = DesiredCapabilities.firefox();
dc.setCapability("marionette", true);
WebDriver driver =  new FirefoxDriver(dc);
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("https://google.com");
}

}