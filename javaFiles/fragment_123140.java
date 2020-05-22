import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

class Extract {
    public static void main(String[] args) {

        try {
            File fXmlFile = new File("data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            NodeList topNodes = doc.getElementsByTagName("TXNEXP");
            for (int i = 0; i < topNodes.getLength(); i++) {
                NodeList middleNodes = topNodes.item(i).getChildNodes();
                for (int j = 0; j < middleNodes.getLength(); j++) {
                    try {
                       NodeList theNodes = ((Element)middleNodes.item(j)).getElementsByTagName("PAN");
                       System.out.println(theNodes.item(0).getFirstChild().getNodeValue());
                        if (j == 1) {
                            // modify a value                                                                                                                                                               
                            theNodes.item(0).getFirstChild().setNodeValue("4567");
                            System.out.println(theNodes.item(0).getFirstChild().getNodeValue());
                        }

                    } catch (ClassCastException e) {}
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}