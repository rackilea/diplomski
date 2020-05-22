import java.io.*;
import java.util.Random;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class SplitXML {
    public static void main(String[] args) throws Exception {
        File input = new File(args[0]);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = dbf.newDocumentBuilder().parse(input);
        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodes = (NodeList) xpath.evaluate("//root/envelope", doc, XPathConstants.NODESET);
        int itemsPerFile = 1;

        Document currentDoc = dbf.newDocumentBuilder().newDocument();

        for (int i=0; i < nodes.getLength(); i++) {
            Node rootNode = currentDoc.createElement("root");

            Node imported = currentDoc.importNode(nodes.item(i), true);
            rootNode.appendChild(imported);

            Node staff = doc.getElementsByTagName("envelope").item(i);
            NamedNodeMap attr = staff.getAttributes();
            Node nodeAttr = attr.getNamedItem("fileID");
            String filename = nodeAttr.getNodeValue();
            String[] fileParts = filename.split("\\.");

            if (i % itemsPerFile == 0) {
                File currentFile = new File(fileParts[0] + "." + fileParts[1].toLowerCase());
                writeToFile(rootNode, currentFile);
            }
        }
    }

    private static void writeToFile(Node node, File file) throws Exception {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(node), new StreamResult(new FileWriter(file)));
    }
}