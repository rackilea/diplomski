@RunWith(Theories.class)
public class TheoryTest {
  @DataPoints
  public static Long[] data() {
    return new Long[] { Long.valueOf(3), Long.valueOf(4) };
  }

  @Theory
  public void test1(Long input) {
    System.out.println("test1 input=" + input);
  }

  @AfterClass
  public static void afterClass() {
    System.out.println("afterClass");
  }
}