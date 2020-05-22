import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class Testing {

public static void main(String[] args) {

                HtmlUnitDriver driver = new HtmlUnitDriver();
                driver.setJavascriptEnabled(true);
                driver.get("https://secure.indeed.com/account/login?service=my&hl=en_CA&co=CA");
                driver.findElement(By.xpath("//*[@id=\"signin_email\"]")).sendKeys("notworking@gmail.com");
                driver.findElement(By.xpath("//*[@id=\"signin_password\"]")).sendKeys("needHelp");
                driver.findElement(By.xpath("//*[@id=\"loginform\"]/button")).click();  
                driver.quit(); 

 } 
}