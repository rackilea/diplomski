import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public static void main(String[] args) throws Exception {
    String url = "http://api.traileraddict.com/?film=fifty-shades-of-grey&count=1";
    parse(url);
}

public static void parse(String strUrl) throws Exception {
    URL url = new URL(strUrl);
    URLConnection connection = url.openConnection();
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    try (InputStream is = connection.getInputStream()) {
        Document doc = db.parse(is);
        NodeList nList = doc.getElementsByTagName("embed");
        Node embedItem = nList.item(0);
        System.out.println(embedItem.getTextContent());
    }
}