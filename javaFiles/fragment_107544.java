public class config{

static WebDriver driver;

@BeforeSuite
public void setup(){

    driver=new FirefoxDriver();

}

@AfterSuite
public void tearDown(){
    driver.quit();
}

}