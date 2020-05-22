File file = new File("path_to_firebug-2.0.17.xpi");
FirefoxProfile firefoxProfile = new FirefoxProfile();
firefoxProfile.addExtension(file);
firefoxProfile.setPreference("extensions.firebug.currentVersion", "2.0.17"); 

WebDriver driver = new FirefoxDriver(firefoxProfile);