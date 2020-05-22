@RunWith(Parameterized.class) public class FooTest {
  private boolean flag = true;
  private String param;

  public FooTest(String param) {
    this.param = param;
  }

  @Test(timeout = 1000) public void test() {
    while(true == flag);
    param = null;
  }

  @After public void after() {
    Assert.assertNull("Problem:" + param, param);
  }

  @Parameters public static Collection<Object[]> params() {
    Object[][] params = { { "foo" } };
    return Arrays.asList(params);
  }
}