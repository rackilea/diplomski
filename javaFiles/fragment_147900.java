@RunWith(Parameterized.class)
public class YourTest {
  @Parameters
  public static Object[][] dataSets() {
    return new Object[][] {
      { new X("x1"), new Y("y1") },
      { new X("x2"), new Y("y2") },
      ...
    }
  }

  @Parameter(0)
  public X x;

  @Parameter(1)
  public Y y;

  @Test
  public void checkSomething() {
    //do something with x and y.
  } 
}