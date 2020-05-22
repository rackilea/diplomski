import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

public class HtmlFun {

   public static void main(String[] args) throws Exception {
      URL url = new URL("http://www.google.com");
      URLConnection conn = url.openConnection();
      conn.setConnectTimeout(1000);
      conn.setReadTimeout(1000);
      conn.setRequestProperty("User-Agent", "Mozilla");

      Source source = new Source(conn);
      List elems = source.getAllElements();
      for(Element elem : elems) {
         System.out.println(elem);
      }
   }
}