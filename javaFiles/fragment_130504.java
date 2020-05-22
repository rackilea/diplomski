@RunWith(Parameterized.class)
public class LambdaParameters {

  public static Integer toot() { return 0; }
  public static Integer whistle() { return 1; }
  public static Integer plunk() { return 2; }
  public static Integer boom() { return 3; }

  private static Supplier<Integer> wrap(Supplier<Integer> methodCall) {
    return methodCall;
  }

  @Parameters public static List<Object[]> parameters() {
    return ImmutableList.of(
      // Java 8 knows that static call "toot" is effectively a Supplier<Integer>...
      new Object[] { (Supplier<Integer>) LambdaParameters::toot, 0 },
      // ...but it won't infer that without the cast...
      new Object[] { (Supplier<Integer>) LambdaParameters::whistle, 1 },
      // ...or without getting the hint through a method like "wrap" above.
      new Object[] { wrap(LambdaParameters::plunk), 2 },
      // Most lambda expressions are for calling Runnables, Listeners, Callbacks,
      // and short Functions or Predicates, so the casts there aren't necesssary.

      // You can use this syntax for compact lambda functions too.
      new Object[] { wrap(() -> 3), 3 },

      // All of these are effectively anonymous inner classes as you might see
      // in previous versions of Java.
      new Object[] { new Supplier<Integer>() { @Override public Integer get() { return LambdaParameters.boom(); }}, 3 }
    );
  }

  private Supplier<Integer> supplier;
  private Integer integer;

  public LambdaParameters(Supplier<Integer> supplier, Integer integer) {
    this.supplier = supplier;
    this.integer = integer;
  }

  @Test public void supplierSuppliesExpectedInteger() {
    assertEquals(integer, supplier.get());
  }
}