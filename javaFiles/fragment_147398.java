public class LoginIntoVendors 
{
    @Test
       public void verifyLoginVendors() throws Exception
       {
           WebDriver driver = DriverInit.getInstance().getDriver();

           IntiationPage vendorInit=PageFactory.initElements(driver, IntiationPage.class);

           vendorInit.clickOnLoginButton();

           VendorsLoginAction Loginven=PageFactory.initElements(driver, VendorsLoginAction.class);

           Loginven.vendorlogin("***","***@gmail.com", "****");

           String title = driver.getTitle();
           System.out.println("Title is  :" + title  );


       }
}