import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;



public class Master_Test extends Configurations {

    @Before
    public void setUP() {
        testConfiguration();
        driver.get("http://www.google.com");
    }

    @Test
    public void masterTest() {
        TestCase1 test = new TestCase1(driver);
        test.test1();
    }
}