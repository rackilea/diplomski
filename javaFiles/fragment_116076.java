public class Base {


public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

//Input client under test
public static final String Client = "Client1";

//Input default environment under test
public static final String DefaultEnvironment = "Chrome_Hub";


//CALL WEB BROWSER AND OPEN WEBSITE
public static void openURL(String environment) throws InterruptedException, IOException {

    try{

        if(environment.equals("Chrome_Hub")) {
            System.setProperty("webdriver.chrome.driver", "/Users/rossdonohoe/Desktop/SeleniumJava/Drivers/chromedriver");
            driver.set(new ChromeDriver());
        }
        if(environment.equals("Firefox_Hub")) {
            System.setProperty("webdriver.gecko.driver", "/Users/rossdonohoe/Desktop/SeleniumJava/Drivers/geckodriver");
            driver.set(new FirefoxDriver());
        }

        driver.get(DataFinder.ReadData("front end url"));


    }
    catch(Exception E) {
        E.printStackTrace();
    }
}
}