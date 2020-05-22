WebDriver driver = new FirefoxDriver();
//create an object of EventFiringWebDriver and pass the driver instance
EventFiringWebDriver wd = new EventFiringWebDriver(driver);
//create an object of  class WebDriverListener and pass the driver instance
WebDriverListener eventListener = new WebDriverListener(driver);
wd.register(eventListener);