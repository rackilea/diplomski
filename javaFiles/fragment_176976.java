/**
 * A single entry point for all soft assertions, AssertJ standard assertions and MyProject custom assertions.
 */
// extending make all standard AssertJ assertions available
public class GuavaJUnitSoftAssertions extends JUnitSoftAssertions {

  public <K, V> MultimapAssert<K, V> assertThat(final Multimap<K, V> actual) {
    return proxy(MultimapAssert.class, Multimap.class, actual);
  }

  // add the other guava assertThat methods 
  // ... 
}