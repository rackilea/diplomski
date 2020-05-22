public class VendorsHomePageTest 

{
    public WebDriver driver;
    @Test
    public void verifyVendorsHomePageTest() throws Exception
    {

        driver = DriverInit.getInstance().getDriver();

        LoginIntoVendors login=PageFactory.initElements(driver, LoginIntoVendors.class);

        login.verifyLoginVendors();

        VendorsHomePageApp vhpapp= PageFactory.initElements(driver, VendorsHomePageApp.class);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);

        vhpapp.clickOnNotificationsTab();

        vhpapp.clickOnProfileTab();

        vhpapp.clickOnTendersTab();

        vhpapp.clickOnDashboardTab();

        vhpapp.clickOnFirstTender();

    }

}