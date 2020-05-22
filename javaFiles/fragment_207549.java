import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class gg {

  public static void main(String[] args)
  {


     String browser = "Chrome";

     WebDriver driver = null;

     if(browser.equals("Mozilla"))
     {
      driver = new FirefoxDriver();
     }
     else 
     {
         if(browser.equals("Chrome"))
         {
            System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
         }
         else
         {
            if(browser.equals("IE"))
            {
               System.setProperty("webdriver.IE.driver", "C:\\Users\\Ryuk~\\Downloads\\IEDriverServer_x64_2.43.0\\IEDriverServer.exe");
               driver = new InternetExplorerDriver();
            }
         }
      }
      if(driver !null)
      {
         driver.get("https://gmail.com");
         System.out.println(driver.getTitle());
      }
   }
}