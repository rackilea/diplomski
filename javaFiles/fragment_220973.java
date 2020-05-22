import org.apache.commons.text.StringEscapeUtils;
public class EscapeTest {
  public static void main(String[] args) {
    final String s = "&lt;PARA&gt; S&amp;amp;P &lt;/PARA&gt;";
    System.out.println(StringEscapeUtils.unescapeXml(s));
  }
}