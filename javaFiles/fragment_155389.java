package forum11688757;

import java.io.File;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File("src/forum11688757/input.xml"));

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        NodeList nodeList = (NodeList) xpath.evaluate("/mesh/triangles/p", document, XPathConstants.NODESET);
        for(int x=0; x<nodeList.getLength(); x++) {
            System.out.println(nodeList.item(x).getTextContent());
        }
    }

}