public class ImmutableObj {

  // Simply make this public instead of getter since it is read-only
  public final List<String> internals;

  public ImmutableObj(String[] strings) {
    internals = Collections.unmodifiableList(Arrays.asList(strings));
  }

}