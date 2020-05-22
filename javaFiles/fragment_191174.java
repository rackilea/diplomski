private WebDriver driver;
 public TestUI(Environment.DriverToUse drv){
   switch (drv){
        case CHROME:{
            ChromeDriverService service = ChromeDriverService.createDefaultService();
            File file = new File(TestUI.class.getResource("/chromedriver.exe").toURI());
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, file.getAbsolutePath());                
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(service,options);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            break;
        }
        case FIREFOX:{
            FirefoxProfile ffProfile = new FirefoxProfile();
            ffProfile.setPreference("browser.safebrowsing.malware.enabled", false);
            driver = new FirefoxDriver(ffProfile);
            driver.manage().window().setPosition(new Point(0, 0));
            java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
            driver.manage().window().setSize(dim);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            break;

        }    

public WebDriver getDriver(){
 return driver;
}