public class A {
  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    if (driver = null) {
      driver = new InternetExplorerDriver();
      driver.get(C.getURL());
      driver.switchTo().frame("top_frame");
      driver.manage().window().maximize();
    }
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod(ITestResult result) {
    if (result.getStatus() = FAILURE) {
       driver.quit();
       driver = null;
    } 
  }    

  @AfterClass(alwaysRun = true)
  public void tearDown(ITestContext textContext) throws IOException {
    report.flush();
    if (driver != null) {
      driver.quit();       
    }   
  }    
}