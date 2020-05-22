import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExtractInfo  {

   public static void main (String [] args) throws IOException{ 

       Document doc = Jsoup.connect("http://www.brimfieldfleafinder.com/dealersservc.php").get(); //get the page
       Elements dealersList = doc.select("dealer"); // select all dealer tags
       for (Element dealer : dealersList){     
           Elements dealerInfos = dealer.children();   // for each dealer tag select all child tags
           for(Element inf : dealerInfos){
               System.out.println(inf.tagName() +" : "+ inf.text());  //print tag name and if exists tag text
           }
           System.out.println("********************************");
       }
   }
}