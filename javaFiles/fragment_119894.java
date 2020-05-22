import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParsin {
public static void main(String[] args) {
    try {
        File file = new File("Your Example");
        DocumentBuilder dBuilder = 
        DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        System.out.println("Root element :" + d doc.getDocumentElement().getNodeName());

        Map<String, String> news = new HashMap<>();
        if (doc.hasChildNodes()) {
            news = printNote(doc.getChildNodes());
        }


        for (Map.Entry<String, String> entries : news.entrySet()) {
            System.out.println(entries.getKey() + entries.getValue());
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

private static Map<String, String> printNote(NodeList nodeList) {
    String newsTitle = "", newsDate = "";
    Map<String, String> data = new HashMap<>();
    try {
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node tempNode = nodeList.item(count);

            if (tempNode.getNodeName().equalsIgnoreCase("title"))
                newsTitle = tempNode.getTextContent();
            if (tempNode.getNodeName().equalsIgnoreCase("date"))
                newsDate = tempNode.getTextContent();


            if (tempNode.hasChildNodes()) {
                printNote(tempNode.getChildNodes());
            }
        }
        if(!newsDate.isEmpty() && !newsTitle.isEmpty()){
            data.put(newsDate, newsTitle);
        }
        for (Map.Entry<String, String> entries : data.entrySet()) {
            System.out.println(entries.getKey() + entries.getValue());
        }
    } catch (Exception e) {
        System.out.println(e);
    }


    return data;
}