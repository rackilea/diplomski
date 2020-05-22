import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class Main {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document dom = builder.parse(new FileInputStream("c://tmp//tmp.xml"));

        XPath xPath = XPathFactory.newInstance().newXPath();
        System.out.println(xPath.compile("//Detail//ReturnMessage").evaluate(dom));
    }    
}