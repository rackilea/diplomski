import org.junit.Assert;
import org.junit.Test;

public class MyTest {
  @Test
  public void test() {
    Object alo = null;
    assert alo != null         // Line 9
    Assert.assertNotNull(alo); // Line 10
  }
}