import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// ...

private List<String> getRssLinks() throws ParserConfigurationException,
    SAXException, IOException 
{
  final List<String> rssLinks = new LinkedList<String>();
  final URL url = new URL("http://news.yahoo.com/rss/");
  final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                       .parse(url.openStream());
  final NodeList linkNodes = doc.getElementsByTagName("link");
  for(int i = 0; i < linkNodes.getLength(); i++) {
    final Element linkElement = (Element) linkNodes.item(i);
    rssLinks.add(linkElement.getTextContent());
  }

  return rssLinks;
}