import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.CustomCleaner;
import org.jsoup.safety.Whitelist;

public class CustomJsoupSanitizer {

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.parse(new File("t2.html"), "UTF-8");
            CustomCleaner cleaner = new CustomCleaner(Whitelist.relaxed().addTags("script"));
            Document doc2 = cleaner.clean(doc);
            System.out.println(doc2.html());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}