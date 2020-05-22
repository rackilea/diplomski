public class HomePageTest {

public static HtmlUnitDriver driver;

@Before
public void setUp() throws Exception {
   driver = new HtmlUnitDriver();
}

@Test
public void initiateTest() throws Exception {
      driver.get("http://localhost/test3.html");
      List<WebElement> elems = driver.findElementsByXPath("//option");
      for (WebElement e : elems)
      {
          System.out.println(e.getText());
      }
}

@After
public void tearDown() throws Exception {
driver.close();
} }