System.setProperty("webdriver.gecko.driver", "gecko/linux/geckodriver");

FirefoxProfile profile = new FirefoxProfile();
profile.setPreference("network.proxy.no_proxies_on", "localhost");
profile.setPreference("javascript.enabled", true);

DesiredCapabilities capabilities = DesiredCapabilities.firefox();
capabilities.setCapability("marionette", true);
capabilities.setCapability(FirefoxDriver.PROFILE, profile);

FirefoxOptions options = new FirefoxOptions();
options.merge(capabilities);
options.setLogLevel(Level.FINEST);
options.addPreference("browser.link.open_newwindow", 3);
options.addPreference("browser.link.open_newwindow.restriction", 0);

WebDriver driver = new FirefoxDriver(options);