public class ImmutableObj {

  private final String[] internals;

  public ImmutableObj(String[] strings) {
    internals = Arrays.copyOf(strings, strings.length);
  }

  public String[] getInternals() {
    // return a copy of the internal state, since arrays
    // do not offer an immutable view
    return Arrays.copyOf(internals, internals.length);
  }
}