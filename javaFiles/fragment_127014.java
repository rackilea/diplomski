// Setting your Chrome options (Desired capabilities)
ChromeOptions options = new ChromeOptions();
options.add_argument('--start-maximized');
options.add_argument('--start-fullscreen');

// Creating a driver instance with the previous capabilities
WebDriver driver = new ChromeDriver(options);

// Load page & take screenshot of full-screen page
driver.get("http://google.com");
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);