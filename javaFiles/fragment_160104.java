DesiredCapabilities capabilities = DesiredCapabilities.chrome();

String chromeDirPath = "provided here a path where you want to custom chrome dir which could be use everty time you launch"
//ensure chromeDirPath exist in dir

ChromeOptions options = new ChromeOptions();
options.addArguments("--user-data-dir="+chromeDirPath);

capabilities.setCapability(ChromeOptions.CAPABILITY, options);

WebDriver driver = new ChromeDriver(capabilities);
driver.get("url");