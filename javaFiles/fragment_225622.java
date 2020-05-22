import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {

    public static Map<String,String> hMap = new LinkedHashMap<>();
    public static void main(String argv[]) {

        try {

            File fXmlFile = new File("C:\\Users\\jaikant\\Desktop\\QUESTION.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("bookParameter");

            for (int parameter = 0; parameter < nodeList.getLength(); parameter++) {
                Node node = nodeList.item(parameter);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String value = eElement.getElementsByTagName("value").item(0).getTextContent();
                    hMap.put(name, value);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        hMap.forEach((h,k) -> {
            System.out.println(h + ":" + k);
        });
    }

}