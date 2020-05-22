public class TestCase{
   public WebDriver driver;

   @BeforeTest
   public void setUp(){
       driver = new ChromeDriver();
   }