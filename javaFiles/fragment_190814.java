import org.junit.*;
import org.junit.rules.ErrorCollector;

public class ABC_Test {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @Before
    public void setUp() {
       //steps = new WebDriverSteps(new FirefoxDriver());
       //steps = new WebDriverSteps();
    }

   @Test
   public void check() {
      CheckVal dv = new CheckVal(collector);

      try {
          dv.checkTable("4234");
      } catch (AssertionError er) {
        System.out.println("22");
      } catch (Exception e) {
        System.out.println("23");
      } catch (Throwable t) {
        System.out.println("24");
      }
  }