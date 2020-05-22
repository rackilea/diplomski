WebDriver driver;

@Given("^Open Firefox and Start Application$")
public void Open_Firefox_and_Start_Application() throws Throwable 
{
    System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\chromedriver\\chromedriver.exe");
    driver =  new ChromeDriver();
}