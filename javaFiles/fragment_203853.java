System.setProperty("webdriver.chrome.driver", "res/chromedriver.exe");
DesiredCapabilities capabilities = DesiredCapabilities.chrome();
ChromeOptions options = new ChromeOptions();
options.addArguments("test-type");
options.addArguments("start-maximized");
options.addArguments("user-data-dir=D:/temp/");
capabilities.setCapability("chrome.binary","res/chromedriver.exe");
capabilities.setCapability(ChromeOptions.CAPABILITY,options);
WebDriver driver = new ChromeDriver(capabilities);