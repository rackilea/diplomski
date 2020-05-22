import java.util.regex.*;
class RegexTest {
  public static void main(String args[]) {
    String string = "My Name is batman. I am B012HIOL8L.";
    Pattern p = Pattern.compile("[A-Z0-9]{10}");
    Matcher m = p.matcher(string);
    while (m.find()) {
      System.out.println(m.group());
    }
  }
}