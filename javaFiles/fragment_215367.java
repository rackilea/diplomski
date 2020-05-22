import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class clearTrip_warning {

    public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver", "C:\\SeleniumUtilities\\BrowserDrivers\\chromedriver.exe");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    options.addArguments("--disable-extensions");
    options.addArguments("disable-infobars");
    WebDriver driver = new ChromeDriver(options);
    driver.get("https://www.cleartrip.com/");
    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#SearchBtn"))).click();
    List<String> myFields = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//small[contains(text(),'You missed this')]//preceding::input[2]"))).stream().map(element->element.getAttribute("id")).collect(Collectors.toList());
    System.out.println(myFields);
    }
}