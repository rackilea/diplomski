System.setProperty("webdriver.gecko.driver","path_to_geckodriver.exe");
    File file = new File(path_to_your_firefox_profile);
    DesiredCapabilities dc = DesiredCapabilities.firefox();
    FirefoxProfile profile = new FirefoxProfile(file);
    dc.setCapability(FirefoxDriver.PROFILE, profile);
    FirefoxDriver driver = new FirefoxDriver(dc);
    driver.get("https://www.google.com");