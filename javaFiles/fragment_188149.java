import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class GetVersion {
    public static void main(String[] args) throws Exception {
        XPath xpath = XPathFactory.newInstance().newXPath();
        Document doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder().parse("file:////tmp/whatever.xml");
        String version = xpath.evaluate("//behavior/@version", doc);
        System.out.println(version);
    }
}