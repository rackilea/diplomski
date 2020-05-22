import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FooTest {

    @DataProvider(name = "DriverInfoProvider", parallel = true) // data providers force single threaded by default
    public Object[][] driverInfoProvider() {
        return new Object[][] {
            { "firefox", "47.0", "Windows 10" },
            { "chrome" , "51.0", "Windows 10" },
            // etc, etc
        };
    }

    @Test(dataProvider = "DriverInfoProvider")
    public void testFoo(String browser, String version, String os) {
        WebDriver driver = Driver.createDriver(browser, version, os);
        try {
            // simple output to see the thread for each test method instance
            System.out.println("starting test in thread: " + Thread.currentThread().getName());
            // Putting this in a try catch block because you want to be sure to close the driver to free
            // up the resources even if the test fails
            driver.get("https://www.google.com");
            driver.findElement(By.name("q")).sendKeys("Hello, world");
        } finally {
            driver.quit();
        }
    }
}