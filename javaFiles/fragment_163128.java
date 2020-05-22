import java.io.File;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XPathTest {

    public static void main(String[] args) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("response.xml"));
        XPath xxPath = XPathFactory.newInstance().newXPath();
        String expression = "/Envelope/Body/getUserResponse/return/user";
        javax.xml.xpath.XPathExpression cc = xxPath.compile(expression);
        String result  = cc.evaluate(doc);
        System.out.println("Result:: " + result);
    }
}