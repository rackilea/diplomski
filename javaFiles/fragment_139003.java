import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ex2 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse("testxml.xml");
            doc.getDocumentElement().normalize();

            NodeList nodelist = doc.getElementsByTagName("wsdl:message");
            //System.out.println("No. of Nodes: "+nodelist.getLength());

            for(int i=0;i<nodelist.getLength();i++){
                Node node=nodelist.item(i);
                String valueOfTag=node.getAttributes().getNamedItem("name").getNodeValue();
                if(valueOfTag.equalsIgnoreCase("debitrequest")){
                    if(node.hasChildNodes()){
                        NodeList childNList=node.getChildNodes();
                        for(int j = 0; j < childNList.getLength();j++)
                        {
                            Node n = childNList.item(j);
                            if(n.getNodeType() == 1) //NodeType 1 = Next XML Node
                            {
                                String nvalue = n.getAttributes().getNamedItem("name").getNodeValue();
                                System.out.println(nvalue);
                            }
                            /*if(n.getAttributes() != null){
                                String s = n.getAttributes().getNamedItem("name").getNodeValue();
                                System.out.println(s);
                            }*/
                        }
                        System.out.println(childNList.getLength());

                    }
                    else{
                        System.out.println("NO CHILD FOUND for: "+valueOfTag);
                    }
                }   
            }
        } catch(Exception io) {
            io.printStackTrace();
        } 
    }
    }