package stackoverflow;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.InputSource;

public class XMLTester {

    public static void main(String[] args)
            throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                + "<User xmlns=\"http://abc.e.wat.com/xml\" SOURCE_NAME=\"PublicAssetFeed\">" + "   <Employee>"
                + "      <FIELD NAME=\"Name\" TYPE=\"char\">Rahul</FIELD>"
                + "      <FIELD NAME=\"Branch\" TYPE=\"char\" />"
                + "      <FIELD NAME=\"Unique ID\" TYPE=\"char\">12345</FIELD>" + "   </Employee>" + "</User>";

        Document doc = readStringAsDocument(xmlStr);

        try {
            printDocument(doc, System.out);
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Node willBeDeleted = null;

        NodeList fieldNodes = doc.getElementsByTagName("FIELD");

        if (fieldNodes.getLength() > 0) {
            for (int i = 0; i < fieldNodes.getLength(); i++) {
                Node node = fieldNodes.item(i);
                NamedNodeMap attributes = node.getAttributes();

                for (int j = 0; j < attributes.getLength(); j++) {
                    Node att = attributes.item(j);

                    if (att.getNodeName().equals("NAME") && att.getNodeValue().equals("Branch")) {
                        willBeDeleted = node;
                    }
                }
            }
        }

        willBeDeleted.getParentNode().removeChild(willBeDeleted);

        try {
            printDocument(doc, System.out);
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static Document readStringAsDocument(String xmlString)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = null;

        db = dbf.newDocumentBuilder();

        Document doc = db.parse(new InputSource(new StringReader(xmlString)));
        return doc;
    }

    // https://stackoverflow.com/a/2325407/2384806
    public static void printDocument(Document doc, OutputStream out) throws IOException, TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        transformer.transform(new DOMSource(doc), new StreamResult(new OutputStreamWriter(out, "UTF-8")));
    }
}