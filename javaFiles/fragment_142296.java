@Test 
public void LoginTest()
{
 Webdriver driver = new FirefoxDriver();
 driver.get("someurl")

 Login_Page lp = new Login_Page(driver);
 lp.genericClick(driver, lp.link1);
}