public class PageAvailable {
WebDriver driver;
@Before
public void be(){

//Set Chromedriver Path
System.setProperty("webdriver.chrome.driver","C:/Users/JARs/chromedriver_win32/chromedriver.exe");

// initialize ChromeDriver instance with the chromdriver exe as set in above line.
driver = new ChromeDriver();

driver.get("....net");

}
@Test
public void test() {
 //Load your URL
driver.get("https://...net");
System.out.println(driver.getTitle());
}
@After
public void af(){
driver.close();
}}