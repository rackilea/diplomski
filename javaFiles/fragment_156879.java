public class ExampleList {
  private final List<String> strings;

  // ...

  public List<String> getStrings() { return Collections.unmodifiableList(strings); }
}