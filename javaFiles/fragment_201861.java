public class BrowserInitializer extends Global 
{
     BrowserInitializer(){
     super();
     this.initialize();
    }

    public void initialize()
    {
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, 5000);
    }
}

//In test class
Global globalObj=new BrowserInitializer();