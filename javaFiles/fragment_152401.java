import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class TestXPath {

    private static final String FILE = "a.xml" ;
    private static final String XPATH = "/script/findme";
    public static void main(String[] args) {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        docFactory.setNamespaceAware(true);
        DocumentBuilder builder;
        try {
            builder = docFactory.newDocumentBuilder();
            Document doc = builder.parse(FILE);
            XPathExpression expr = XPathFactory.newInstance().newXPath().compile(XPATH);
            Object hits = expr.evaluate(doc, XPathConstants.NODESET ) ;
            if ( hits instanceof NodeList ) {
                NodeList list = (NodeList) hits ;
                for (int i = 0; i < list.getLength(); i++ ) {
                    System.out.println( list.item(i).getTextContent() );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}