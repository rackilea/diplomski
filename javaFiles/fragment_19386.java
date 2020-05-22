import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class GetAllTheChildren {
public static void main(String[] args) {

try{
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    documentBuilderFactory.setNamespaceAware(true);
    DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
    Document doc = builder.parse("/home/eugen/Desktop/input.txt");

    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPath xpath = xPathFactory.newXPath();

    XPathExpression expression = xpath.compile("/Inventory/Item[Quantity>200]/*");

    NodeList nodes = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);

    for(int i = 0;i<nodes.getLength();i++){
        System.out.println(nodes.item(i).getNodeName());
        System.out.println(nodes.item(i).getTextContent());
    }
} catch(Exception exception){
    exception.printStackTrace();
}

}