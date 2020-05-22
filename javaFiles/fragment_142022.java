import org.apache.commons.lang.StringEscapeUtils;

public class StringEscapeUtilsTrial {
public static void main(String[] args) {
    String strHTMLInput = "<p>MyName<p>";
    String strEscapeHTML = StringEscapeUtils.escapeHtml(strHTMLInput);
    String strUnEscapeHTML = StringEscapeUtils.unescapeHtml(strEscapeHTML);
    System.out.println("Escaped HTML >>> " + strEscapeHTML);
    System.out.println("UnEscaped HTML >>> " + strUnEscapeHTML);
    }
}