public class TestA {
  private Things thing;
  private A a;

  @Before
  public void setUp() {
    thing = createMock(Things.class);
    a = new A(thing);
  }

  @Test
  public void addTest(){
      // You should keep only one of these examples
      // 1. You don't care about checking `345`. You just want to make sure there is a call. `anyObject` is exactly what you need
     thing.addBall(anyObject());
     // 2. You want to expect a `Ball` with `345` 
     thing.addBall(cmp(new Ball(345), Comparator.comparingInt(Ball::getSize), LogicalOperator.EQUAL));
    // 3. You prefer a simpler check possibly on many attributes. Just capture the `Ball` passed in parameter and check after if it contains what you want
    Capture<Ball> capture = Capture.newInstance();
    thing.addBall(capture(capture));
    // Now the original code
    replay(thing);
    a.add(345);
    verify(thing);
    // Assert on the capture is you used solution #3
    assertEquals(345, capture.getValue().getSize());
  }
}