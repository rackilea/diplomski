System.setProperty("webdriver.chrome.driver", "C:\\your_directory\\chromedriver.exe");
ChromeOptions opt = new ChromeOptions();
opt.addArguments("disable-infobars");
opt.addArguments("--start-maximized");
opt.addArguments("--disable-extensions");
WebDriver driver = new ChromeDriver(opt);
driver.get("https://google.com");