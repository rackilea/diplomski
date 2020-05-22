@RunWith(JUnit4.class) public class AbstractClassTest {
  /** Minimial AbstractClass implementation for testing. */
  public static class SimpleConcreteClass extends AbstractClass {
    public SimpleConcreteClass() { super("foo", "bar", 42); }
    @Override public void abstractMethod1() {}
    @Override public String abstractMethod2(int parameter) { return ""; }
  }

  @InjectMocks SimpleConcreteClass classUnderTest;
  @Mock mockClassA;
  @Mock mockClassB;
}