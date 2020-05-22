import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Xpather {
    public static void main(String[] args) 
            throws XPathExpressionException, ParserConfigurationException, 
            SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new InputSource("workbook.xml"));
        XPath xpath = XPathFactory.newInstance().newXPath();
        Node body = (Node) xpath.evaluate("/request/response/body", doc,
                XPathConstants.NODE);
        System.out.println(body.getTextContent());
        Node url = (Node) xpath.evaluate("/request/@url", doc,
                XPathConstants.NODE);
        System.out.println(url.getNodeValue());
    }
}