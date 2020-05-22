public class Pawan {

public static WebDriver driver;

@BeforeClass
public static setup() {

System.setProperty("webdriver.gecko.driver","C:\\Users\\Lalit-pc\\Desktop\\geckodriver-v0.21.0-win64\\geckodriver.exe");

driver = new FirefoxDriver();

}

// Urs test here