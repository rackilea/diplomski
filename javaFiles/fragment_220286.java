import org.apache.commons.lang.StringEscapeUtils;

public class Test {
    public static void main(String[] args) {
        String str = "&auml;s&aring;";
        System.out.println(StringEscapeUtils.unescapeHtml(str)); // prints äså
    }
}