import java.io.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class XpathDemo
{
    public static void main(String[] args)
    {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDoc = builder.parse(new InputSource(new FileReader("C://Temp/xx.xml")));

            // Selects all CONSUMER_PROFILE2 elements no matter where they are in the document
            String cp2_nodes = "//CONSUMER_PROFILE2";
            // Selects first DATE_OF_BIRTH element somewhere under current element
            String dob_nodes = "//DATE_OF_BIRTH[1]";
            // Selects text child node of current element
            String text_node = "/child::text()";

            XPath xPath =  XPathFactory.newInstance().newXPath();
            NodeList dob_list = (NodeList)xPath.compile(cp2_nodes + dob_nodes + text_node)
                    .evaluate(xmlDoc, XPathConstants.NODESET);
            for (int i = 0; i < dob_list.getLength() ; i++) {
                Node dob_node = dob_list.item(i);
                String dob_text = dob_node.getNodeValue();
                System.out.println(dob_text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}