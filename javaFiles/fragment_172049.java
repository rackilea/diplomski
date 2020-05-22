import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;

public class ChangeVersion
{
    public static void main(String[] args)
            throws Exception
    {
        if (args.length < 3) {
            System.err.println("Usage: ChangeVersion <input> <output> <new version>");
            System.exit(1);
        }

        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);
        int updatedVersion = Integer.parseInt(args[2], 10);

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = domFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(inputFile);

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        XPathExpression expr = xpath.compile("/PremiereData/Project/@Version");

        NodeList versionAttrNodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < versionAttrNodes.getLength(); i++) {
            Attr versionAttr = (Attr) versionAttrNodes.item(i);
            versionAttr.setNodeValue(String.valueOf(updatedVersion));
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(outputFile));
    }
}