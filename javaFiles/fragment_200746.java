import junit.framework.TestCase;

public class JUnitTest extends TestCase {
  public void test() {
    assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});
  }
}