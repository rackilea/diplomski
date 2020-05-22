import java.io.File;
import javax.xml.*;
import org.w3c.dom.*;

public class DeleteXmlNode {

    public static void deleteNode(String nodedetailsExpression) {//Use your expression here depending upon the node you wnt to delete

        try{
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        XPathExpression expression = xpath.compile(nodedetailsExpression);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = documentBuilderFactory.newDocumentBuilder().parse(new File("test.xml"));
        Node node = (Node) expression.evaluate(document, XPathConstants.NODE);
        node.getParentNode().removeChild(node);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(System.out));
        }catch(Exception e){
        //Do your Exception handling over here.
    }

}