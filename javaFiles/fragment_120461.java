import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class Foo {
    public static void main(String[] args) throws Exception {
        // --------- LOAD XML
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(new InputSource(new StringReader("<createCustomer>\r\n" + 
                "    <customerAttributes>\r\n" + 
                "        <firstName></firstName>\r\n" + 
                "        <lastName></lastName>\r\n" + 
                "    </customerAttributes>\r\n" + 
                "</createCustomer>")));

        // --------- PROCESS
        NodeList customerNodes = doc.getElementsByTagName("customerAttributes");

        for (int i = 0; i < customerNodes.getLength(); i++) {
            NodeList children = customerNodes.item(i).getChildNodes();
            for (int j = 0; j < children.getLength(); j++) {
                String childNode = children.item(j).getNodeName();
                if (childNode.equalsIgnoreCase("firstName")) {
                    children.item(j).setTextContent(String.valueOf("John"));
                }
                else if (childNode.equalsIgnoreCase("lastName")) {
                    children.item(j).setTextContent(String.valueOf("Doe"));
                }
            }  
        }

        // --------- OUTPUT
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        StringWriter writer = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(writer));
        System.out.println(writer.getBuffer().toString());
    }
}