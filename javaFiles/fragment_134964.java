import org.apache.commons.lang.StringEscapeUtils;

public class MainClass {
    public static void main(String[] args) {
        String strHTMLInput = "<P>MyName<P>";
        String strEscapeHTML = StringEscapeUtils.escapeHtml(strHTMLInput);
        String strUnEscapeHTML = StringEscapeUtils.unescapeHtml(strEscapeHTML);
        System.out.println("Escaped HTML >>> " + strEscapeHTML);
        System.out.println("UnEscaped HTML >>> " + strUnEscapeHTML);
    }
}