package forum12746038;

import java.io.StringReader;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        String xml = "<root>Hello <!-- comment -->World</root>";
        Document doc = db.parse(new InputSource(new StringReader(xml)));

        Element element = doc.getDocumentElement();
        NodeList childNodes = element.getChildNodes();
        StringBuilder strBldr = new StringBuilder();
        for(int x=0; x<childNodes.getLength(); x++) {
            Node childNode = childNodes.item(x);
            if(childNode.getNodeType() == Node.TEXT_NODE) {
                strBldr.append(childNode.getNodeValue());
            }
        }
        System.out.println(strBldr.toString());
    }

}