public class BaseTest{
    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void startSuite(){
        driver = new FirefoxDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void endSuite(){
        driver.quit();
    }

}

public class Login extends BaseTest{
    @Test
    public void doLogin(){
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("USERNAME");
    }
}