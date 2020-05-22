import java.io.File;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;



public class Teste {

    public static void main(String[] args) {
        try {
            // read and clean document
            TagNode tagNode = new HtmlCleaner().clean(new File("test.xml"));
            Document document = new DomSerializer(new CleanerProperties()).createDOM(tagNode);

            // use XPath to find target node
            XPath xpath = XPathFactory.newInstance().newXPath();
            Node node = (Node) xpath.evaluate("//*[text()='content']", document, XPathConstants.NODE);

            // assembles jquery/css selector
            String result = "";
            while (node != null && node.getParentNode() != null) {
                result = readPath(node) + " " + result;
                node = node.getParentNode();
            }
            System.out.println(result);
            // returns html body div#myDiv.foo.bar p#tID 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Gets id and class attributes of this node
    private static String readPath(Node node) {
        NamedNodeMap attributes = node.getAttributes();
        String id = readAttribute(attributes.getNamedItem("id"), "#");
        String clazz = readAttribute(attributes.getNamedItem("class"), ".");
        return node.getNodeName() + id + clazz;
    }

    // Read attribute
    private static String readAttribute(Node node, String token) {
        String result = "";
        if(node != null) {
            result = token + node.getTextContent().replace(" ", token);
        }
        return result;
    }

}