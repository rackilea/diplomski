import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class DomParsing {

    public static final String ECB_DATAS ="C:\\xml\\eurofxref-hist-90d.xml"; 


    public static void main(String argv[]) {

    try {

        File fXmlFile = new File(ECB_DATAS);
        DocumentBuilderFactory dbFactory =     DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        doc.getDocumentElement().normalize();

        System.out.println("Root element :" +         doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("Cube");

        for (int temp = 0; temp < nList.getLength(); temp++) {

            Node nNode = nList.item(temp);

            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;


                System.out.println("currency : " +   eElement.getAttribute("currency") + " and rate is " +   eElement.getAttribute("rate"));

        }
    }
   } catch (Exception e) {
     e.printStackTrace();
   }
  }

}