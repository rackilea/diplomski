import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(".*product/(.*)/ref.*");
        Matcher matcher = pattern.matcher("https://www.amazon.de/gp/product/SOMETEXTHERE/ref=oh_aui_detailpage_o00_s00?ie=UTF8&psc=1");
        if (matcher.matches()) {
            System.out.println(matcher.group(1));
        }
    }
}