WebDriver driver;

@BeforeTest
public void setup()
{
    System.setProperty("webdriver.gecko.driver", "C:\\Utility\\BrowserDrivers\\geckodriver.exe");
    DesiredCapabilities dc = DesiredCapabilities.firefox();
    dc.setCapability("marionette", true);
    driver =  new FirefoxDriver(dc);
    driver.manage().window().maximize();
}

@Test
public void openBrowser(){
    driver.get("https://www.levissima.it/");
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.manage().window().maximize();
}
@Test
public void verify_Menus(){

    WebElement mainMenu = driver.findElement(By.xpath("//ul[@id='menu-main']/li/a"));

    WebElement subMenu = driver.findElement(By.xpath("//a[contains(text(),'Impegno Per La Natura')]"));
    Actions action = new Actions (driver);
    action.moveToElement(mainMenu).perform();
    action.click(subMenu).perform();
}