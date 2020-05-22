package navi;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Himanshu {
    public static WebDriver driver;  
    @BeforeClass
    public static void setUpClass() {
        FirefoxOptions options = new FirefoxOptions();
        ProfilesIni allProfiles = new ProfilesIni();         
        FirefoxProfile selenium_profile = allProfiles.getProfile("selenium_profile");
        options.setProfile(selenium_profile);
        options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\pburgr\\Desktop\\geckodriver-v0.20.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        }   
    @Before public void setUp() {} @After public void tearDown() {}
    @AfterClass public static void tearDownClass() {driver.quit();}
    @Test
    public void lots_of_buttons() throws InterruptedException {
        driver.get("http://www.bbc.com/");
        // wait to page is fully loaded
        wait_sec(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"orb-header\"]/div[1]/div[1]/a/img")));

        // get all the desired webelements
        List<WebElement> header_links = driver.findElements(By.xpath("//a[contains(@href,'x')]"));

        // create new arraylist
        ArrayList<String> hrefs = new ArrayList<String>();  

        // collect all the href values
        for (WebElement link: header_links) {
            hrefs.add(link.getAttribute("href"));
        }

        // visit all the URLs
        for (String url: hrefs) {
            driver.get(url);
            Thread.sleep(1000);
            // do some stuff here
        }
    }

    // modified wait method
    public WebDriverWait wait_sec(WebDriver driver, int sec) {
        return new WebDriverWait(driver, sec);
    }
}