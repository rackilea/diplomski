System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.addArguments("--headless");
chromeOptions.addArguments("start-maximized");
chromeOptions.addArguments("--disable-gpu");
chromeOptions.addArguments("--disable-extensions"); 
WebDriver driver =  new ChromeDriver(chromeOptions);
driver.get("https://www.google.co.in");