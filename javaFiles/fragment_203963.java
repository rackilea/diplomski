import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Kader {
   private static final String MAIN_URL = "http://www.latijnengrieks.com/categorie.php?id=120";
   private static final String ALL_LINKS = "a[href]";
   private static Element maintable;

   public static void main(String[] args) {
      Document jsDoc = null;

      try {
         jsDoc = Jsoup.connect(MAIN_URL).get();
         maintable = jsDoc.select(".kader").first();

         Elements alllinks = maintable.select(ALL_LINKS);

         String[] translationLinks = getTranslationLinks(alllinks);

         for (String tLink : translationLinks) {
            System.out.println(tLink);
         }

      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static String[] getTranslationLinks(Elements alllinks){
      String[] items = new String[alllinks.size()];
      Element tempelement;
      for(int i = 0;i<items.length;i++){
          tempelement = alllinks.get(i);

          items[i] = tempelement.attr("abs:href");
      }
      return items;
  }
}