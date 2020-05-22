import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTester {
    public static void main(String[] args) throws Exception {
        String html = "<P>This is Stack overflow</p>"
                + "<p>---------------</p>"
                + "<p>---------------</p>"
                + "<p>This is stack overflow2</p>";
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("p");

        for(Element e : elements) {
            System.out.println(e.text());
        }
    }
}