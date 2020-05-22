import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
  public static void main(String[] args) {
    String text = "this is a junk line\n" + 
        "\n" + 
        "#ifdef FEATURE \n" + 
        "#endif // end of FEATURE\n" + 
        "\n" + 
        "this is a junk line\n" + 
        "\n" + 
        "#ifdef FEATURE\n" + 
        "\n" + 
        "this is a junk line that should be matched: HOLasduiqwhei & // FEATURE fjfefj #endif // h\n" + 
        "\n" + 
        "#endif FEATURE\n" + 
        "\n" + 
        "this is a junk line";

    // this version does not use Pattern.MULTILINE, this should reduce the backtraking
    Matcher matcher2 = Pattern.compile("\\n#ifdef FEATURE((?:\\r?\\n(?!#endif (?:// end of )?FEATURE).*)*)\\r?\\n#endif (?:// end of )?FEATURE").matcher(text);
    while (matcher2.find()) {
      System.out.println(matcher2.group());
    }

  }
}