package JUnitTesting;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlockTeamURLDomain {
    static WebDriver driver;
    String TeamUrl = "http://farzanshaikh.flock.co/";
    String TeamName = "<script>farzan</script>";
    String TeamDomain = "farzanshaikh.com";

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get(TeamUrl);

    }

    @Test
    public void OpenTheTeamURL() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        String Title = driver.getTitle();
        System.out.println("The title of the Page is: "+Title);
        if(Title.equals("Flock - Team")){
            System.out.println("The Title is Correct");
        }
        else{
            System.err.println("The Title is InCorrect");
        }
        Thread.sleep(2000);
    }
    @Test
    public void CheckTheFooter() {
        boolean FlockFooter = driver.findElement(By.cssSelector("//div[@id='team-page']/div[2]/div[5]")).isDisplayed();
        System.out.println("Is the Footer Present? "+FlockFooter);

    }
    @Test
    public void CheckAndClickLogo() {
        boolean FlockLogo = driver.findElement(By.xpath("//div[@id='team-page']//img")).isDisplayed();
        System.out.println("Is Flock Logo Displayed "+FlockLogo);
    }
    @Test
    public void CheckTheHeader() {
        boolean FlockHeaderLogo = driver.findElement(By.xpath("//div[@id='step-2-block']/span")).isDisplayed();
        System.out.println("Is the Header Element Present? "+FlockHeaderLogo);

    }



    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        Thread.sleep(3000);
        driver.quit();
    }



}