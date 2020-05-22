import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.OutputKeys;
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
import java.io.StringWriter;

public static String toString(Node node, boolean omitXmlDeclaration, boolean prettyPrint) {
    if (node == null) {
        throw new IllegalArgumentException("node is null.");
    }

    try {
        // Remove unwanted whitespaces
        node.normalize();
        XPath xpath = XPathFactory.newInstance().newXPath();
        XPathExpression expr = xpath.compile("//text()[normalize-space()='']");
        NodeList nodeList = (NodeList)expr.evaluate(node, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); ++i) {
            Node nd = nodeList.item(i);
            nd.getParentNode().removeChild(nd);
        }

        // Create and setup transformer
        Transformer transformer =  TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        if (omitXmlDeclaration == true) {
           transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        }

        if (prettyPrint == true) {
           transformer.setOutputProperty(OutputKeys.INDENT, "yes");
           transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        }

        // Turn the node into a string
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(node), new StreamResult(writer));
        return writer.toString();
    } catch (TransformerException e) {
        throw new RuntimeException(e);
    } catch (XPathExpressionException e) {
        throw new RuntimeException(e);
    }
}