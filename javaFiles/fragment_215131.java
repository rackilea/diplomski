import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class YourTest {
   @Test
   @Parameters("configXmlPath")
   public void test1(String configXmlPath) {
      System.out.println("Parameterized value is : " + configXmlPath);
   }
}