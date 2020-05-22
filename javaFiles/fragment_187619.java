ChromeOptions regularUser = new ChromeOptions();
ChromeOptions adminUser = new ChromeOptions();
regularUser.addUserProfilePreference(yourRegularUserPreferences);
adminUser.addUserProfilePreference(yourAdminUserPreferences);

//When testing regular user
WebDriver driver = new RemoteWebDriver(new Uri("http://path/to/selenium/server"), regularUser.toCapabilities());

//When testing admin user
WebDriver driver = new RemoteWebDriver(new Uri("http://path/to/selenium/server"), adminUser.toCapabilities());