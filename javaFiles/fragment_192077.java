// Initialize Webdriver and then asks your common function to return it
private WebDriver driver;

@BeforeTest
public void launchBrowser() {
  driver = ReuseFunctions.OpenApp("Chrome", "https://gmail.com");
}

@Test(priority=1)
public void LoginToGmailAccount() {
   // pass driver as a method argument to other methods
}

//Don't forget to close the browser
@AfterTest
public void quitBrowser() {
  driver.quit();
}