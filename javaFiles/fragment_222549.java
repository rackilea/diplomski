WebDriver driver = new FirefoxDriver();
driver.manage().window().maximize();
driver.get("http://www.example.com");
HomePage homePage = new HomePage(driver);
homePage.clickSampleElement();
// do stuff that changes the page and makes the element stale
homePage.clickSampleElement();