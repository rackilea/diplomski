import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.opshub.exceptions.DataValidationException;

public class Test{
    public static void main(String[] args) throws DataValidationException, IOException, ParserConfigurationException, SAXException{
        File fXmlFile = new File("F:\\checkouts\\current\\Test.hbm.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);
        NodeList nodes = doc.getChildNodes();
        for(int i=0;i<nodes.getLength();i++){
            printElements(nodes.item(i));
        }
    }
    public static void printElements(org.w3c.dom.Node node){
        if(node.ELEMENT_NODE != node.getNodeType())
            return;
        System.out.println(node.getNodeName());
        if(node.hasChildNodes()){
            for(int i=0;i<node.getChildNodes().getLength();i++){
                printElements(node.getChildNodes().item(i));
            }
        }
        System.out.println("/" + node.getNodeName());
    }

}