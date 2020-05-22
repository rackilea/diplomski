public class b  {
    static WebDriver driver;

    public static void setDriver( WebDriver driver){
        b.driver = driver;
    }

    public static void Execute(WebDriver driver){

        homepage.phonenumber(driver).sendKeys(constant.Phonenumber);
        homepage.proceedbutton(driver).click();

    }


    public static void closebrowser(){  
        driver.close();         
    }
}