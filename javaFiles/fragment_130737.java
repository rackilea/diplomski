import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupSO {

    public static void main(String args0[]) throws IOException {
        Document doc;
        Elements elements;

        doc = Jsoup.parse(new File("path_to_file or use connect for URL"), "UTF-8");

        elements = doc.getElementsByClass("unread");
        for (Element element : elements) {
            System.out.println(element);
        }

        elements = doc.getElementsByClass("read");
        for (Element element : elements) {
            System.out.println(element);
        }
    }

}