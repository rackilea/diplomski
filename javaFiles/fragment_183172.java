import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class Sample {

    public static void main(String[] args) throws IOException {

        System.out.println(getPrivacyNotice("http://www.gameloft.com/privacy-notice/","div.terms"));
        System.out.println(getPrivacyNotice("http://outfit7.com/privacy-policy/#","div#main"));

    }
    public static String getPrivacyNotice(String url, String tag)throws IOException {
        Document doc= Jsoup.connect(url).get();
        return doc.select(tag).first().text();
    }
}