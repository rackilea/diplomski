public class Example {
  public static void main(final String... args) {
    Pattern p = Pattern.compile("([^\\s]+)?(\\s)+");
    String mystring = "one two three";
    final Matcher matcher = p.matcher(mystring);
    matcher.find();
    System.out.println(matcher.end());
  }
}