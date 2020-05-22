import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
  private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
  public WebDriverWait wait;
  protected FirefoxProfile profile;
  protected String url = "http://www.qaclickacademy.com/";

  protected String testSuiteName;
  protected String testName;
  protected String testMethodName;

  public WebDriver getDriver() {
    return drivers.get();
  }

  @BeforeMethod()
  public void setUp(Method method, ITestContext ctx) {
    String testName = ctx.getCurrentXmlTest().getName();

    WebDriver driver = BrowserDriverFactory.createDriver("firefox");
    drivers.set(driver);
    driver.get(url);

    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, 5);

    this.testSuiteName = ctx.getSuite().getName();
    this.testName = testName;
    this.testMethodName = method.getName();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown(ITestResult result) {
    getDriver().quit();
    drivers.remove();
  }
}