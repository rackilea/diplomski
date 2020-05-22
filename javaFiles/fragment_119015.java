import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {
        try {
            String str = "<div><h2 class=\"?class-text \">mark-text should be blue</h2></div>"; 
            Document doc = Jsoup.parse(str);

            Elements el = doc.getElementsByClass("?class-text");
            System.out.println(el);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}