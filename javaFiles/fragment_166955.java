public class TestClass {

public WebDriver driver; public String baseUrl;

@BeforeMethod
public void Homepage() {

driver = new FirefoxDriver();
baseUrl = "http://www.indeed.co.uk";

}

// as we declared baseUrl globally and assigned value in beforetest, so we use this variable in @tests now

 @Test
public void Setup() {

driver.get(baseUrl);`
} 
}