public class Test extends AstractTest {
 private static int lock = 0;    //Here the lock is initiated once

@DataProvider(name = "Test", parallel = true)
public Object[][] loadInputDataFromExcel() {
    return Taf.files().populateExcelDataProvider(getGlobalInputDataFileName("testsConfig"));
}

@Test(description="Simultaneous Login", dataProvider="Test", enabled=true)
public void SimultaneousLogin(Map<String, String> dp) throws InterruptedException {

    setupThreadedBrowserDriver(dp.get("browser")); 

    actionNavigateToPage(dp.get("url"));

    LoginPage loginPage = new LoginPage();

    loginPage.login(dp.get("PersonalNumber"), "password");
    lock++;
    // surround the login button with synchronized block
    synchronized (this) {
        while (lock < 3)
            this.wait();
        this.notifyAll();
        loginPage.loginBtn.clickButton();
    }