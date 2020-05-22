import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Veri {

    public static void main(String[] args) {

        Veri();

    }

    public static void Veri() {

        try {

            String url = "https://www.isyatirim.com.tr/tr-tr/analiz/hisse/Sayfalar/default.aspx";

            Response res = Jsoup.connect(url).timeout(6000).execute();

            Document doc = res.parse();
            Element ele = doc.select("table[class=dataTable hover nowrap excelexport]").first();
            Elements lines = ele.select("tr");
            for (Element elt : lines) {
                System.out.println(elt.text());
                System.out.println("------------------------");
            }

        } catch (IOException c) {

            JOptionPane.showMessageDialog(null, "Veriler Alınırken Bir Harta Oluştu!");
            c.printStackTrace();
        }

    }

}