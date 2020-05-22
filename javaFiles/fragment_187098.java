@AutoFactory
final class SomeClass {
  private final String providedDepA;
  private final String depB;

  SomeClass(@Provided @AQualifier String providedDepA, String depB) {
    this.providedDepA = providedDepA;
    this.depB = depB;
  }

  // …
}