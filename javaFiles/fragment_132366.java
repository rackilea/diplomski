System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe");

//Now you can Initialize marionette driver to launch firefox
DesiredCapabilities capabilities = DesiredCapabilities.firefox();
capabilities.setCapability("marionette", true);

WebDriver driver = new MarionetteDriver(capabilities); //for selenium 3 use new FirefoxDriver(capabilities);