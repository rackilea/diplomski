public class class1 {

    //public WebDriver object so that it can be used anywhere within class1
    public WebDriver driver; 

    //public WebDriverWait object so that it can be used anywhere within class1
    public WebDriverWait wait;

    @BeforeClass
    public void setup()
        {
            System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
            driver = new FirefoxDriver();
            wait = new WebDriverWait(driver,15); //explicit wait to increase performance
        }

    @Test()
    public void login() {

        driver.get("https://facebook.com/");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("srikanth");
        driver.findElement(By.id("password")).sendKeys("sri");
        driver.findElement(By.id("login_button")).click();

        }
    }