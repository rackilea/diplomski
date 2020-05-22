import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.xml.sax.InputSource;

public class Test {

  public static final String xml = 
    "<queries>"
    + "  <query id=\"getUserByName\">"
    + "    select * from users where name=?"
    + "  </query>"
    + "  <query id=\"getUserByEmail\">"
    + "    select * from users where email=?" 
    + "  </query>"
    + "</queries>"; 


  public static void main(String[] args) throws Exception {
    System.out.println(getQuery("getUserByName"));
    System.out.println(getQuery("getUserByEmail"));

  }

  public static String getQuery (String id) throws Exception {
    InputStream is = new ByteArrayInputStream(xml.getBytes("UTF8"));
    InputSource inputSource = new InputSource(is);
    XPath xpath = XPathFactory.newInstance().newXPath();
    return xpath.evaluate("/queries/query[@id='" + id +"']", inputSource);
  }
}