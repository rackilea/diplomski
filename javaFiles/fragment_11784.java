System.setProperty("webdriver.gecko.driver", "path/to/geckodriver")

ProfilesIni profile = new ProfilesIni();
FirefoxProfile myprofile = profile.getProfile("created Profile Name");

WebDriver driver = new FirefoxDriver(myprofile);
driver.get("untrusted/self-signed URL");