import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DOMParser {
    public static void main(final String[] args) throws SAXException, IOException, ParserConfigurationException {
        String xml = "<Entry>"
                + "<MediaID>434234242342</MediaID>"
                + "<MediaName>Brazil</MediaName>"
                + "<PhoneNo>"
                    + "<Ip>23232323232</Ip>"
                    + "<Ip>32323232323</Ip>"
                    + "<Ip>323232323232</Ip>"
                + "</PhoneNo>"
            + "</Entry>";
        DOMParser parser = new DOMParser();
        final Document doc = parser.getDomElement(xml);
        parser.parse(doc.getDocumentElement());
    }

    public void parse(final Element e) {
        final NodeList children = e.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            final Node n = children.item(i);
            if(n.getNodeType() == Node.TEXT_NODE){
            System.out.println(n.getTextContent());
            } else if (n.getNodeType() == Node.ELEMENT_NODE) {
            System.out.print(n.getNodeName() + " : ");
            parse((Element) n);
            }
        }
    }

    public Document getDomElement(String xml){
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            doc = db.parse(is); 

            } catch (ParserConfigurationException e) {
            return null;
            } catch (SAXException e) {
            return null;
            } catch (IOException e) {
            return null;
            }

            return doc;
        }
}