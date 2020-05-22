package jhy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class NewsTest {
    public static void main(String... args) throws IOException {
        String url = "https://google.com/search?q=Apple+&tbm=nws&num=100&tbs=cdr%3A1%2Ccd_min%3A01%2F19%2F2016%2Ccd_max%3A01%2F23%2F2016";
        Document doc = Jsoup.connect(url).get();

        Elements links = doc.select("h3 a");
        for (String title : links.eachText()) {
            System.out.println(title);
        }
    }
}