String os = System.getProperty("os.name");
public String currentBrowser;
if(CONFIG.getProperty("browserType").contains(","))
{
  data=currentBrowser;
}
if (os.contains("Windows")) 
{     
    else if (data.equals("Chrome")) {
    APP_LOGS.debug("Chrome Browser Opening Method Start");
    DesiredCapabilities capability = DesiredCapabilities.chrome();
    // To Accept SSL certificate
    capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    System.setProperty("webdriver.chrome.driver",
            CONFIG.getProperty("ChromeDriver"));
    Thread.sleep(10000);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

    long 
    implicitWaitTime=Long.parseLong(CONFIG.getProperty("implicitwait"));
    driver.manage().timeouts().implicitlyWait(implicitWaitTime, 
    TimeUnit.SECONDS);
    driver.manage().window().maximize();
}
    return os;
}