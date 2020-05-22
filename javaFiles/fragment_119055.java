public class QaToolsECommercePageObjects {

  WebDriver driver;

  public void setBrowser(int browser){
        WebDriver driver
        if(browser == 1){
            driver = new FirefoxDriver();
        }else if(browser == 2){
            System.setProperty("webdriver.chrome.driver", "C:/Users/chetan.k.thimmanna/Documents/Selenium/Resources/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser == 3){
            System.setProperty("webdriver.ie.driver", "C:/Users/chetan.k.thimmanna/Documents/Selenium/Resources/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        //Maximize the window
        driver.manage().window().maximize();

        driver.get("http://store.demoqa.com/");
        //driver.get("http://toolsqa.com/");

        //browser load time
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
 -----
 -----
}