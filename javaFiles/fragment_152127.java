package question2_try1;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ProcessXML {

 public static void main (String[] args) {
  
  try {
   File fXmlFile = new File("C:\\Users\\User\\Desktop\\ST eletronics\\Q2_20170206112222.xml");
   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
   Document doc = dBuilder.parse(fXmlFile);
   
   doc.getDocumentElement().normalize();
   
   System.out.println("Root element :" +doc.getDocumentElement().getNodeName());
   
   //controlsummary & items
   
   
   System.out.println("Control summary :" +doc.getElementsByTagName("totalrecords").item(0).getTextContent());
   
   
   
   NodeList nList = doc.getElementsByTagName("item");
   
   System.out.println("----------------------------");
   
   for (int temp = 0; temp < nList.getLength(); temp++) {

    Node nNode = nList.item(temp);
    
    System.out.println("\nCurrent Element :" + nNode.getNodeName());

    if (nNode.getNodeType() == Node.ELEMENT_NODE) {

     Element eElement = (Element) nNode;

     System.out.println("Data : " + eElement.getElementsByTagName("data").item(0).getTextContent());
     System.out.println("Data datetime : " + eElement.getElementsByTagName("data_datetime").item(0).getTextContent());
     System.out.println("Total a : " + eElement.getElementsByTagName("total_a").item(0).getTextContent());
     System.out.println("Total a in unit : " + eElement.getElementsByTagName("total_a_in_unit").item(0).getTextContent());
     System.out.println("Total b : " + eElement.getElementsByTagName("total_b").item(0).getTextContent());
     System.out.println("Total b in unit : " + eElement.getElementsByTagName("total_b_in_unit").item(0).getTextContent());
     System.out.println("Loc id : " + eElement.getElementsByTagName("loc_id").item(0).getTextContent());
     System.out.println("Loc desc : " + eElement.getElementsByTagName("loc_desc").item(0).getTextContent());
     System.out.println("Company id : " + eElement.getElementsByTagName("company_id").item(0).getTextContent());
     System.out.println("Company Name : " + eElement.getElementsByTagName("company_name").item(0).getTextContent());

    }
   }
       NodeList npricesList = doc.getElementsByTagName("price");
  
  System.out.println("============[- _ -]======================");
  
  for (int temp = 0; temp < npricesList.getLength(); temp++) {

   Node nNode = npricesList.item(temp);
   
   System.out.println("\nCurrent Element :" + nNode.getNodeName());

   if (nNode.getNodeType() == Node.ELEMENT_NODE) {

    Element eElement = (Element) nNode;

    System.out.println("Data : " + eElement.getElementsByTagName("data").item(0).getTextContent());
    System.out.println("price : " + eElement.getElementsByTagName("unitPrice").item(0).getTextContent());
    

   }
  }
   
  }catch (Exception e) {
  e.printStackTrace(); 
  }
 } 
}