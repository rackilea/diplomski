package selenium.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class ExampleSearch  {
    public static void main(String[] args) {

        WebDriver driver = new HtmlUnitDriver();

        // Open Google
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("selenium best practices");

        // Send form with element 
        element.submit();
    }
}