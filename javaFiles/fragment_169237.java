import java.io.FileReader;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        XPath xPath = XPathFactory.newInstance().newXPath();

        FileReader reader = new FileReader("input.xml");
        InputSource xml = new InputSource(reader);
        NodeList titleNodes = (NodeList) xPath.evaluate("//item/title", xml, XPathConstants.NODESET);

        for(int x=0; x<titleNodes.getLength(); x++) {
            System.out.println(titleNodes.item(x).getTextContent());
        }
    }

}