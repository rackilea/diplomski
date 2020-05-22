System.setProperty("webdriver.gecko.driver", "C:\\path\\to\\geckodriver.exe");
ProfilesIni profile = new ProfilesIni();
FirefoxProfile testprofile = profile.getProfile("debanjan");
DesiredCapabilities dc = DesiredCapabilities.firefox();
dc.setCapability(FirefoxDriver.PROFILE, testprofile);
FirefoxOptions opt = new FirefoxOptions();
opt.merge(dc);
WebDriver driver =  new FirefoxDriver(opt);
driver.get("https://www.google.com");