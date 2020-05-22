package unitTest.myTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GoogleTestNGTest {
  @Test
  public void f() throws InterruptedException 
  {
      WebDriver driver=new FirefoxDriver();
        driver.get("http://www.googl.com");
        Thread.sleep(2000);
        driver.close();
try
{
driver.get("someURL");
}
catch(UnreachableBrowserException e){}
}