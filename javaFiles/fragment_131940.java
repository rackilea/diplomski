FirefoxOptions foptions =  new FirefoxOptions();
FirefoxProfile firefoxProfile = new FirefoxProfile(pathToProfile);
foptions.setProfile(firefoxProfile);
foptions.setCapability("marionette", false);
foptions.setBinary("C:\\Program Files\\Mozilla Firefox 52\\firefox.exe"); 
WebDriver driver = new FirefoxDriver(foptions);