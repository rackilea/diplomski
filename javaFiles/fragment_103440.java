import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlParser {

public static void main(String[] args) throws IOException{
    String url = "http://stackoverflow.com/questions/16794913/data-scraping-with-scrapy";
    Document document = Jsoup.connect(url).get();

    String question = document.select(".question .postcell").text();

    System.out.println(question);
}