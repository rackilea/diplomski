import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;

public class MagicXml {
    static XPath xpath = XPathFactory.newInstance().newXPath();
    Document doc;
    Element root;

    public MagicXml(String xml) throws Exception {
        doc = parseXml(xml);
        root = doc.getDocumentElement();
    }

    private static Document parseXml(String xml) throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        ByteArrayInputStream bis = new ByteArrayInputStream(xml.getBytes());
        return docBuilder.parse(bis);
    }

    private String asXPath(String path) {
        return path.startsWith("/") ? path : "//" + path;
    }

    private static Node findNode(Document doc, String xPath) throws Exception {
        XPathExpression expr = xpath.compile(xPath);
        return (Node) expr.evaluate(doc, XPathConstants.NODE);
    }

    public static MagicXml createXml(String xml) throws Exception {
        return new MagicXml(xml);
    }

    public MagicXml addNode(String path, String xml) throws Exception {
        Document subDoc = parseXml(xml);
        Node destNode = findNode(doc, asXPath(path));
        Node srcNode = subDoc.getFirstChild();
        destNode.appendChild(doc.adoptNode(srcNode.cloneNode(true)));
        return this;
    }

    public MagicXml removeNode(String path) throws Exception {
        Node destNode = findNode(doc, asXPath(path));
        destNode.getParentNode().removeChild(destNode);
        return this;
    }

    public MagicXml addAttribute(String path, String attr, String value) throws Exception {
        Element destNode = (Element)findNode(doc, asXPath(path));
        destNode.setAttribute(attr, value);
        return this;
    }

    public MagicXml removeAttribute(String path, String attr) throws Exception {
        Element destNode = (Element)findNode(doc, asXPath(path));
        destNode.removeAttribute(attr);
        return this;
    }

    public String docToString(Document doc) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public String toString() {
        return docToString(doc);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(//
                MagicXml.createXml("<team name='cougars'><players><player name='Michael'/></players></team>")//
                .addNode("players", "<player name='Frank'/>")//
                .addNode("players", "<player name='Delete Me'/>")//
                .removeNode("player[@name='Delete Me']") //
                .addAttribute("player[@name='Frank']", "foo", "bar") //
                .addAttribute("player[@name='Frank']", "bar", "bazz") //
                .removeAttribute("player[@name='Frank']", "bar") //
                .toString());
    }
}