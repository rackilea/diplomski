public class LoginLogoutScript extends Base {


  @Test (priority = 2)
  public void login() throws InterruptedException, IOException {
        LoginLogout.loginFrontEnd();
        Assert.assertTrue(driver.getPageSource().contains("My Account") || driver.get().getPageSource().contains("My Dashboard"));
  }

  @Parameters({ "Environment" })
  @BeforeClass
  public void setUp(@Optional(DefaultEnvironment) String Environment) throws InterruptedException, IOException {
      Base.openURL(Environment);
  }

  @AfterClass public void tearDown() { 
      Base.driver.get().quit(); 
  }

}