/**
 * Associates a series of regular expressions with values, allowing the values
 * to be looked up by strings that match a pattern.
 *
 * Note this is a linear-time operation, and that patterns are checked in
 * insertion order.
 */
public class RegexLookup<V> {
  // Pattern doesn't override .equals()/.hashCode(), so it can't be the map key
  // use a LinkedHashMap to ensure ordered search
  private final LinkedHashMap<String, Pattern> patterns = new HashMap<>();
  private final HashMap<String, V> values = new HashMap<>();

  /** Associates a regular expression with a value */
  public void putPattern(String regex, V value) {
    putPattern(Pattern.compile(regex), regex);
  }

  /** Associates a regular expression with a value */
  public void putPattern(Pattern pattern, V value) {
    patterns.put(pattern.pattern(), pattern);
    values.put(pattern.pattern(), value);
  }

  /**
   * Looks for a pattern matching the given string, and returns the associated
   * value. If not match is found, returns {@link Optional#absent}.
   */
  public Optional<V> find(String string) {
    for (Entry<String, Pattern> e : patterns.entrySet()) {
      if (e.getValue().matcher(string).matches()) {
        return Optional.of(values.get(e.getKey()));
      }
    }
    return Optional.absent();
  }

  /** Returns a read-only view of the underlying pattern:value mapping. */
  public Map<String, V> asPatternMap() {
    return Collections.unmodifiableMap(values);
  }
}