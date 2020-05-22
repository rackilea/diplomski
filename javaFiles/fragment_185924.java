driver = new FirefoxDriver();  // 1st instance
    baseUrl = "URL";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    System.setProperty("webdriver.gecko.driver", "C:\\Users\\ayre1de\\Downloads\\geckodriver-v0.18.0-win64\\geckodriver.exe");
    WebDriver driver = new FirefoxDriver(); // 2nd instance
    driver.get("URL");