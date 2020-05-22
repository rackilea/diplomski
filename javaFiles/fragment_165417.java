package scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraper {

    public static void main(String[] args) throws Exception {
        final Document document = 
                Jsoup.connect("https://www.indeed.com.pk/jobs?q=java&l=")
                .userAgent("Mozilla")
                .cookie("auth", "token")
                .timeout(3000)
                .get();
        scrape(document);

        // Move to the next page
        Element page = document.select("div.pagination a").get(1);
        System.out.println("Page link: " + page.attr("href"));
        Document pageDoc = Jsoup.connect(page.attr("abs:href")).get();
        scrape(pageDoc);
    }

    public static void scrape(Document document) {
        Elements rows = document.select("div.row.result") ;

        for (Element row : rows) {
            Elements innerDivs = row.select("div");
            String header = innerDivs.get(1).text();
            String content = innerDivs.get(2).text();
            System.out.println("header = "+header+ " -> "+content);
        }
    }
}