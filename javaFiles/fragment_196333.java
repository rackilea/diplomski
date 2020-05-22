import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase1 extends Configurations {

    public TestCase1(WebDriver driver) {
        this.driver = driver;
    }

    public void test1() {
        driver.findElement(By.id("lst-ib")).sendKeys("test");
    }
}