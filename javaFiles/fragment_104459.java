public class IsATestObjectWithValue extends TypeSafeMatcher<TestObject> {
  private final String expectedValue;

  public IsATestObjectWithValue(String expectedValue) {
    super(TestObject.class);
    this.expectedValue = expectedValue;
  }

  @Override public void matchesSafely(TestObject object) {
    // object will never be null, but object.value might.
    return expectedValue.equals(object.value);
  }
}