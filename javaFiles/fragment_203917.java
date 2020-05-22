System.setProperty("webdriver.chrome.driver","D:\\Workspace\\JmeterWebdriverProject\\src\\lib\\chromedriver.exe");
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.addArguments("--headless");
chromeOptions.addArguments("--start-maximized");
WebDriver driver = new ChromeDriver(chromeOptions);
driver.get("https://www.google.co.in/");