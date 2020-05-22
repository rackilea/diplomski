import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class A {
    public static void main(String[] args) {
        String html = "<html><head><title>First parse</title></head><body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        Element pTag = doc.select("body > p").first(); // the p tag
        String pContent = pTag.text();
        pContent = pContent.substring(0, 7) + "... (too long)";
        pTag.text(pContent);
        System.out.println(doc);
    }
}