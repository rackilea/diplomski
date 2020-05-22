import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WINDOW_HANDLE_ITERATE_Firefox 
{
    public static void main(String[] args) throws Exception 
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
        WebDriver driver =  new FirefoxDriver();
        driver.get("http://www.google.com");
        String parent_window = driver.getWindowHandle();
        System.out.println("Parent Window Handle is: "+driver.getWindowHandle());
        System.out.println("Page Title is: "+driver.getTitle());
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com/');");
        new WebDriverWait(driver,10).until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allWindows_1 = driver.getWindowHandles();
        System.out.println("Total Windows: "+allWindows_1.size());
        for(String hand1:allWindows_1)
        if(!parent_window.equals(hand1))
        {
            driver.switchTo().window(hand1);
            new WebDriverWait(driver,10).until(ExpectedConditions.titleContains("Facebook"));
            String first_child_window = driver.getWindowHandle();
            System.out.println("First Child Window Handle is: "+first_child_window);
            System.out.println("First Child Window Page Title is: "+driver.getTitle());
            driver.close();
        }
        driver.switchTo().window(parent_window);
        System.out.println("Current Window Handle is : "+driver.getWindowHandle()+ " which is same as "+parent_window +", which is the parent window handle" );
        driver.quit();
    }
}