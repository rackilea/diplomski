package mytest;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author 
 */
public class ManifestParser {

    public static void Parse(String fileName) {

    try 
    {
        File file = new File(fileName);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();
        System.out.println("Root element " + doc.getDocumentElement().getNodeName());
        NodeList nodeLst = doc.getElementsByTagName("application");
        System.out.println("Information of all activities");

        for (int s = 0; s < nodeLst.getLength(); s++) {


            Node fstNode = nodeLst.item(s);

          if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

            Element fstElmnt = (Element) fstNode;
            NodeList fstNmElmntLst = fstElmnt.getChildNodes();
            int sz=fstNmElmntLst.getLength();


            for(int nodes=0;nodes<sz;nodes++)
            {
                Node tempNode=fstNmElmntLst.item(nodes);
                if (tempNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element tmpElmnt = (Element) tempNode;
                    NamedNodeMap nn=tmpElmnt.getAttributes();

                    if(tmpElmnt.getNodeName().equals("activity"))System.out.println("a: "+tmpElmnt.getAttribute("android:name"));
                }
            }

          }

       }
    } catch (Exception e) {
      e.printStackTrace();
    }
   }



}