System.setProperty("webdriver.gecko.driver", "C:/Utility/BrowserDrivers/geckodriver.exe");
ProfilesIni profile = new ProfilesIni();
FirefoxProfile testprofile = profile.getProfile("debanjan");
testprofile.setAcceptUntrustedCertificates(true);
testprofile.setAssumeUntrustedCertificateIssuer(true);
WebDriver driver = new FirefoxDriver(testprofile);
driver.get("https://www.w3schools.com/");