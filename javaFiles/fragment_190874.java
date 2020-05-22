public class Superclass
{
  public WebDriver driver;
  public Superclass(){
    driver = new FirefoxDriver();
  }
  public WebDriver getdriver(){
    if (driver == null){
      driver = new FirefoxDriver();
      return driver;
    }else{
      return driver;
    }
  }
}