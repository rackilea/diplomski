@BeforeTest
public void setup() 
{
    System.setProperty("webdriver.chrome.driver", my_path);
    ChromeOptions options = new ChromeOptions();
    options.addArguments("test-type");
    options.addArguments("start-maximized");
    options.addArguments("--js-flags=--expose-gc");  
    options.addArguments("--enable-precise-memory-info"); 
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-default-apps");
    options.addArguments("test-type=browser");
    options.addArguments("disable-infobars");
    driver = new ChromeDriver(options);        
}