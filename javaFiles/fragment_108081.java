import java.io.IOException;
import java.net.URL;
import org.apache.xerces.parsers.DOMParser;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XMLParser {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        parseXml2("http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esummary.fcgi?db=nucleotide&id=224589801");
    }

    public static void parseXml2(String URL) {
        DOMParser parser = new DOMParser();

        try {
            parser.parse(new InputSource(new URL(URL).openStream()));
            Document doc = parser.getDocument();

            NodeList nodeList = doc.getElementsByTagName("Item");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.print("Item "+(i+1));
                Node n = nodeList.item(i);
                NamedNodeMap m = n.getAttributes();
                System.out.print(" Name: "+m.getNamedItem("Name").getTextContent());
                System.out.print(" Type: "+m.getNamedItem("Type").getTextContent());
                Node actualNode = n.getFirstChild();
                if (actualNode != null) {
                    System.out.println(" "+actualNode.getNodeValue());
                } else {
                    System.out.println(" ");                    
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}