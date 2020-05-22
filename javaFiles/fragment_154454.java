public class PatternBuilder {
  public String regex;
  public boolean multiline;
  public Pattern pattern() {
    int flags = 0;
    if (multiline) flags |= Pattern.MULTILINE;
    return Pattern.compile(regex, flags);
  }
}