import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
/**
* File: Ex1.java @author ronda
*/
public class Ex1 {
public static void main(String[] args) throws Exception {
    DocumentBuilderFactory Factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = Factory.newDocumentBuilder();
    Document doc = builder.parse("myxml.xml");

    //creating an XPathFactory:
    XPathFactory factory = XPathFactory.newInstance();
    //using this factory to create an XPath object: 
    XPath xpath = factory.newXPath();

    // XPath Query for showing all nodes value
    XPathExpression expr = xpath.compile("//" + "item1" + "/*");
    Object result = expr.evaluate(doc, XPathConstants.NODESET);
    NodeList nodes = (NodeList) result;
    System.out.println(nodes.getLength());
    for (int i = 0; i < nodes.getLength(); i++) {

        Element el = (Element) nodes.item(i);

        System.out.println("tag: " + el.getNodeName());
        // seach for the Text children
        if (el.getFirstChild().getNodeType() == Node.TEXT_NODE)
            System.out.println("inner value:" + el.getFirstChild().getNodeValue());

        NodeList children = el.getChildNodes();
        for (int k = 0; k < children.getLength(); k++) {
            Node child = children.item(k);
            if (child.getNodeType() != Node.TEXT_NODE) {
                System.out.println("child tag: " + child.getNodeName());
                if (child.getFirstChild().getNodeType() == Node.TEXT_NODE)
                    System.out.println("inner child value:" + child.getFirstChild().getNodeValue());;
            }
        }
    }
}
}