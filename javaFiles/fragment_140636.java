package tld.domainname.stuff;


import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class XPathTest {
    public static void main(String[] argv) {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "    <soapenv:Body>\n" +
                "        <fixedResearch soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">\n" +
                "            <MYPARAMETER xsi:type=\"xsd:hexBinary\">\n" +
                "                *****bytearray******\n" +
                "            </MYPARAMETER>\n" +
                "        </fixedResearch>\n" +
                "    </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        String value = null;

        XPath xpath = XPathFactory.newInstance().newXPath();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        InputSource is = new InputSource(new StringReader(xmlString));
        try {
            doc = builder.parse(is);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (doc == null) {
            System.out.println("can't parse doc");
            return;
        }

        Node parentNode = doc.getDocumentElement();

        String path = "Body/fixedResearch/MYPARAMETER";

        NodeList nodeList;
        try {
            nodeList = (NodeList) xpath.evaluate(path, parentNode, XPathConstants.NODESET);
        } catch (XPathExpressionException xpe) {
            throw new IllegalArgumentException("Cannot evaluate xpath with path \"" + path + "\"", xpe);
        }

        if ((nodeList == null) || (nodeList.getLength() == 0)) {
            System.out.println("found nothing");
            return;
        }

        if (nodeList.getLength() > 1)
            System.out.println("found " + nodeList.getLength() + " nodes in the path \"" + path + "\" - using only the first");

        Node nextNode = nodeList.item(0);

        if (nextNode == null) {
            System.out.println("found nothing");
            return;
        }

        if (nextNode.hasChildNodes()) {
            Node child = nextNode.getFirstChild();
            value = child.getNodeValue();
        }

        System.out.println("found value of \"" + value + "\"");
    }
}