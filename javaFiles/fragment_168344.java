import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XmlXPathReplace {

    public static void main(final String[] args) throws SAXException, IOException, ParserConfigurationException,
            XPathExpressionException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = factory.newDocumentBuilder();

        // step 1.
        Document doc = builder.parse(new ByteArrayInputStream(( //
                "<?xml version=\"1.0\"?>" + //
                        "<people>" + //
                        "<person><name>First Person Name</name></person>" + //
                        "<person><name>Second Person Name</name></person>" + //
                        "</people>" //
                ).getBytes()));

        // step 2
        String fragment = "<name>Changed Name</name>";
        Document fragmentDoc = builder.parse(new ByteArrayInputStream(fragment.getBytes()));

        // step 3
        Node injectedNode = doc.adoptNode(fragmentDoc.getFirstChild());

        // step 4
        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression expr = xPath.compile("//people/person[2]/name");
        System.out.println();
        Element nodeFound = (Element) expr.evaluate(doc, XPathConstants.NODE);

        // step 5
        Node parentNode = nodeFound.getParentNode();
        parentNode.removeChild(nodeFound);
        parentNode.appendChild(injectedNode);

        DOMSource domSource = new DOMSource(doc);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        StreamResult result = new StreamResult(new StringWriter());
        transformer.transform(domSource, result);
        System.out.println(result.getWriter().toString());
    }

}