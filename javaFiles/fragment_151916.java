public class config{

 static WebDriver driver;

 @BeforeSuite
 public void setup(){

driver=new FirefoxDriver(); //here use your setup

}

@AfterSuite
public void tearDown(){
driver.quit();
}

}