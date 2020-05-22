@Test(priority = 0, testName="Verify Login")
public void login(ITestContext context) throws Exception {
    lp = new LoginPage(driver, test);
    tm = new TabMenu(driver, test);
    driver.get(Constants.url);
    lp.verifyLoginPageLogo(context.getName(), 0);
    lp.setUserName("admin");
    lp.setPassword("admin");
    lp.clickLoginBtn();
    tm.isCurrentTab("Dashboard", context.getName(), 1);
}

public void verifyLoginPageLogo(String testName, int stepName) throws IOException {
    String name = new Object(){}.getClass().getEnclosingMethod().getName();
    Assert.assertTrue(loginLogo.isDisplayed());
    test.log(LogStatus.PASS, "Logo is displayed", Screenshots.takeScreenshot(driver, testName, stepName, test));      
}

public static String takeScreenshot(WebDriver driver, String testName, int stepName, ExtentTest test) throws IOException {
    String fileName = testName + "_" + stepName ".png";
    // the rest of your screenshot code
}