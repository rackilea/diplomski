public class Baseurl {
    private WebDriver driver; //global variable

    public static WebDriver basic() {
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://www.sears.com/shc/s/CountryChooserView?storeId=10153&catalogId=12605");
       return driver;
    }

    public static void Closebrowser(){
        driver.quit();   //  You wont get an error now :)
    } 
}