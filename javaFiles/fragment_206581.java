import static javax.xml.xpath.XPathConstants.*;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class Xml2into1 {
  public static void main(String[] args) throws Exception {
    // read from files
    InputSource xml1 = new InputSource("xml1.xml");
    InputSource xml2 = new InputSource("xml2.xml");
    // find the node to add to
    XPath xpath = XPathFactory.newInstance()
        .newXPath();
    Node expandedData1 = (Node) xpath.evaluate("//expandedData", xml1, NODE);
    Document doc1 = expandedData1.getOwnerDocument();
    // insert the nodes
    Node expandedData2 = (Node) xpath.evaluate("//expandedData", xml2, NODE);
    expandedData1.getParentNode()
        .replaceChild(doc1.adoptNode(expandedData2), expandedData1);
    // print results
    TransformerFactory.newInstance()
        .newTransformer()
        .transform(new DOMSource(doc1), new StreamResult(System.out));
  }
}