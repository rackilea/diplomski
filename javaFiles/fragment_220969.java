package jsoupex;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Example program to list links from a URL.
 */
public class stackoverflw {
    public static void main(String[] args) throws IOException {

        //Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        //String url = "http://localhost/stov_wiki.html";
        String url = "https://simple.wikipedia.org/wiki/Battle_of_Hastings ";
        //args[0];
        System.out.println("Fetching %s..." + url);

        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.select("span.mw-headline, h2 ~ div, h2 ~ p");

        for (Element elem : elements) {
            if ( elem.hasClass("mw-headline")) {
                System.out.println("************************");
            }
            System.out.println(elem.text());
            if ( elem.hasClass("mw-headline")) {
                System.out.println("************************");
            } else {
                System.out.println("");
            }           
        }
    }
}