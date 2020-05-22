System.setProperty("webdriver.gecko.driver", "C:\\path\\to\\geckodriver.exe");
ProfilesIni profile = new ProfilesIni();
FirefoxProfile testprofile = profile.getProfile("debanjan");
FirefoxOptions opt = new FirefoxOptions();
opt.setProfile(testprofile);
WebDriver driver =  new FirefoxDriver(opt);
driver.get("https://www.google.com");