import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewClass {


  public static void main(String[] args) throws IOException {


      Document doc = Jsoup.connect("http://tamilblog.ishafoundation.org").get();
      Elements section = doc.select("section#content");
      Elements article = section.select("article");
      for (Element a : article) {
        System.out.println("Title : \n" + a.select("a").text());
        System.out.println("Article summary: \n" + a.select("div.entry-summary").text());
      }
    }


}