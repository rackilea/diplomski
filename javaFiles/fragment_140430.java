package parsers;

/**
 *
 * @author Arthur Kushman
 */

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;


public class DOMTest {

  public static void main(String[] args) {
  long time1 = System.currentTimeMillis();
   try {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(new File("/Users/macpro/Desktop/myxml.xml"));
    doc.getDocumentElement().normalize();
    // System.out.println("Root Element: "+doc.getDocumentElement().getNodeName());
    NodeList nodeList = doc.getElementsByTagName("input");
    // System.out.println("Information of all elements in input");

    for (int s=0;s<nodeList.getLength();s++) {
      Node firstNode = nodeList.item(s);
      if (firstNode.getNodeType() == Node.ELEMENT_NODE) {
        Element firstElement = (Element)firstNode;
        NodeList firstNameElementList = firstElement.getElementsByTagName("href");
        Element firstNameElement = (Element)firstNameElementList.item(0);
        NodeList firstName = firstNameElement.getChildNodes();
        System.out.println("First Name: "+((Node)firstName.item(s)).getNodeValue());        
      }
    }


   } catch (Exception ex) {
    System.out.println(ex.getMessage());
    System.exit(1);
   }
  long time2 = System.currentTimeMillis() - time1;
  System.out.println(time2);
  }

}