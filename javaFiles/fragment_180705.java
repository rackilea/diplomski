import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JSoup {
    public static void main(String[] args) {
        String html = "<html><head></head><body><div class=\"post_video\" style=\"background-image:url(http://img.youtube.com/vi/JFf3uazyXco/2.jpg);\"></body></html>";

        Document doc = Jsoup.parse( html );
        Elements elements = doc.getElementsByClass("post_video");

        for( Element e : elements ) {
            String attr = e.attr("style");
            System.out.println( attr.substring( attr.indexOf("http://"), attr.indexOf(")") ) );
        }
    }

}