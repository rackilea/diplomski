import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author blj0011
 */
public class JavaApplication43
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try {
            // TODO code application logic here
            Document document = Jsoup.connect("http://money.cnn.com/data/markets/").get();
            //System.out.println(document.toString());
            Elements spanElements = document.getElementsByTag("span");
            List<String> title = new ArrayList();
            List<String> stockPrice = new ArrayList();
            List<String> stockChange = new ArrayList();

            for (Element element : spanElements) {

                switch (element.className()) {
                    case "column stock-name":
                        title.add(element.text());
                        break;
                    case "column stock-price":
                        stockPrice.add(element.text());
                        break;
                    case "column stock-change":
                        stockChange.add(element.text());
                        break;

                }

            }

            Iterator<String> itTitle = title.iterator();
            Iterator<String> itStockPrice = stockPrice.iterator();
            Iterator<String> itStockChange = stockChange.iterator();
            while (itTitle.hasNext() && itStockPrice.hasNext() && itStockChange.hasNext()) {
                System.out.println(itTitle.next() + " : " + itStockPrice.next() + " ::-:: " + itStockChange.next());
            }
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

}