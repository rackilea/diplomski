ChromeOptions options = new ChromeOptions();
options.addArguments("start-maximized");
DesiredCapabilities capabilities = DesiredCapabilities.chrome();
capabilities.setCapability(ChromeOptions.CAPABILITY, options);
WebDriver driver = new ChromeDriver(capabilities);
driver.get("http://www.google.com");
String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
String netData = ((JavascriptExecutor)driver).executeScript(scriptToExecute).toString();
System.out.println(netData);