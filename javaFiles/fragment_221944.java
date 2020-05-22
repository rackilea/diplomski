import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {
  public JsoupTest() {
    try {
      File input = new File("index.html");
      Document doc = Jsoup.parse(input, "UTF-8", "http://localhost");
      System.out.println(doc.toString());

      Elements spanWithId = doc.select("span#MainContent_trProgramDirector");

      if (spanWithId != null) {
        System.out.printf("Found %d Elements\n", spanWithId.size());

        if (!spanWithId.isEmpty()) {
          Iterator<Element> it = spanWithId.iterator();
          Element element = null;
          while (it.hasNext()) {
            element = it.next();
            System.out.println(element.toString());
          }
        }
      }
    } catch (IOException e) { }
  }

  public static void main(String[] args) {
    new JsoupTest();
  }
}