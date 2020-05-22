import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(
                getNumber(
                        "<Contestants Count = \"4\">" +
                        "<Contestant Name=\"EBI\">7</Contestant>" +
                        "<Contestant Name=\"ATILIA\">13</Contestant>" +
                        "<Contestant Name=\"HAFIZ\">10</Contestant>" +
                        "<Contestant Name=\"ESTRANGED\">9</Contestant>" +
            "</Contestants>", "ATILIA"));
    }

    static int getNumber(String xml, String name) throws Exception {
        int number = 0;
        boolean found = false;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        InputSource inputSourse = new InputSource();
        inputSourse.setCharacterStream(new StringReader(xml));
        Document document = documentBuilder.parse(inputSourse);
        NodeList nodeList = document.getElementsByTagName("Contestant");
        for(int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element)nodeList.item(i);
            if("ATILIA".equals(element.getAttribute("Name"))) {
                number = Integer.parseInt(element.getTextContent());
                found = true;
                break;
            }
        }
        if(!found)
            throw new Exception("Name not found.");
        return number;
    }

}