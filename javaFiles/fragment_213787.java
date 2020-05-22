public class Session1 {
    @Test 
    @Parameters ({"myName","browserType"})
    public void login(String name, String browserType){
        if(browserType.equalsIgnoreCase("firefox")){
        WebDriver driver=new FirefoxDriver();
        driver.get("www.google.co.in/");
        }
        else{
            System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Jars\\chromedriver_win32\\chromedriver.exe");
               WebDriver driver = new ChromeDriver();
               driver.get("https://www.google.co.in/"); 
        }
        System.out.println("login Successful");
          System.out.println(name+"Thread ID: "+Thread.currentThread().getId());
    }