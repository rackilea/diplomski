FirefoxProfile firefoxProfile = new FirefoxProfile();

firefoxProfile.setPreference("browser.download.folderList",2);
firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
firefoxProfile.setPreference("browser.download.dir","c:\\downloads");
firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");
WebDriver driver = new FirefoxDriver(firefoxProfile);