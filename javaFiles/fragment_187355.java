import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;

public class ConvertXml {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException, XPathExpressionException {
        // Your XML-like content
        String xmlString = "xml here";

        // transform xml-Fragment into well-formed xml with root element
        String xmlStringWellformed = "<content>" + xmlString + "</content>";

        // parse well-formed xml
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(xmlStringWellformed)));

        // build xpath expression
        String xPathRemoteHost = "//SI[@name='Channel2']/SI[@name='SecsPortConfig']/SI[@name='Socket']/SI[@name='RemoteHost']/text()";
        String xPathRemotePort = "//SI[@name='Channel2']/SI[@name='SecsPortConfig']/SI[@name='Socket']/SI[@name='RemotePort']/text()";
        XPath xPath = XPathFactory.newInstance().newXPath();

        // Use XPath for extraction
        String remoteHost = (String) xPath.compile(xPathRemoteHost).evaluate(document, XPathConstants.STRING);
        String remotePort = (String) xPath.compile(xPathRemotePort).evaluate(document, XPathConstants.STRING);

        System.out.println("RemoteHost: " + remoteHost);
        System.out.println("RemotePort: " + remotePort);
    }
}