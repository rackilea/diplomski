import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MongoQuery {

    public static void main(String[] args) throws Exception {

        System.setProperty("http.proxyHost", "10.9.248.37");
        System.setProperty("http.proxyPort", "18082");

        Document doc = Jsoup.connect("http://www.querymongo.com/")
                .data("MySQLQuery", "SELECT * FROM STOCK WHERE symbol like 'FLIR%' and price > 24.04 and price < 24.39")
                .post();

        for(Element e : doc.select("#mongoQuery")){
            System.out.println(e.val());
        }
    }
}