import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
public class FireEyeAlert  
{
    public static void main( String args[] ) 
    {
        WebDriver driver = new HtmlUnitDriver();
        driver.get("http://nnnnnn");
        // driver.switchTo().frame( driver.findElement(By.id("frameId")));
        driver.findElement(By.name("utf8")).clear();
        System.out.println("Element found");
        driver.findElement(By.name("utf8")).sendKeys("Jnnnnnn");
        driver.findElement(By.name("authenticity_token")).clear();
        driver.findElement(By.name("authenticity_token")).sendKeys("14nnnnnn!");
        // driver.switchTo().defaultContent();
        System.out.println("Element found");
    }
}