import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class DummyClass
{
    WebDriver driver;
    @Test
    public void test()
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(30, TimeUnit.SECONDS)
            .pollingEvery(5, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);

        until(new Function<WebElement, Boolean>() 
        {
            public Boolean apply(WebElement element)
            {
                return element.getText().endsWith("04");
            }

            private void until(Function<WebElement, Boolean> function)
            {
                driver.findElement(By.linkText("Sample Post2"));
            }
        }
    }
}