//  https://stackoverflow.com/questions/51320827/how-can-i-retrieve-the-child-node-using-xpath-java
//
//  code taken from:    https://stackoverflow.com/a/47280397
//
//
import java.lang.*;
import java.io.*;
import javax.xml.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class xpath {
    public static void main(String[] args) {
        String xpathExpression = "//Placemark/name[./text()='east am']";

        // Read file
        Document doc = null;
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(true);
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File( "test.51320827.xml" );
            FileInputStream stream = new FileInputStream( file );
            doc = builder.parse( stream );
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        // get from XPath
        try {
            XPathFactory xpf = XPathFactory.newInstance();
            XPath xpath = xpf.newXPath();

            XPathExpression compile = xpath.compile(xpathExpression);
            NodeList nodeList = (NodeList) compile.evaluate(doc, XPathConstants.NODESET);

            displayNodeList(nodeList);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        System.out.println("\n===== ***** =====");
    }

    static void displayNodeList( NodeList nodeList ) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            String NodeName = node.getNodeName();

            NodeList childNodes = node.getChildNodes();
            if ( childNodes.getLength() > 1 ) {
                for (int j = 0; j < childNodes.getLength(); j++) {

                    Node child = childNodes.item(j);
                    short nodeType = child.getNodeType();
                    if ( nodeType == 1 ) {
                        System.out.format( "\n\t Node Name:[%s], Text[%s] ", child.getNodeName(), child.getTextContent() );
                    }
                }
            } else {
                System.out.format( "\n Node Name:[%s], Text[%s] ", NodeName, node.getTextContent() );
            }

        }
    }
}