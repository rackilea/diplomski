import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Test {

public static void main(String[] args) throws Exception {
    Test test = new Test();
    String str = test.getCoordinatesContent("D:/test.xml");
    System.out.println(str);
}

public String getCoordinatesContent(String filePath)throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(new File(filePath));
    doc.getDocumentElement().normalize();
    return doc.getElementsByTagName("coordinates").item(0).getTextContent().trim();
  }

}