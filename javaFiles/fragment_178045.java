import org.w3c.dom.*;

public class ReadXML {

    public static void main(String args[]) throws Exception{     

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        // Document elements
        Document doc = docBuilder.parse(new File(args[0]));

        Node firstChild = doc.getFirstChild();
        System.out.println(firstChild.getChildNodes().getLength());
        System.out.println(firstChild.getNodeType());
        System.out.println(firstChild.getNodeName());

        Node root = doc.getDocumentElement();
        System.out.println(root.getChildNodes().getLength());
        System.out.println(root.getNodeType());
        System.out.println(root.getNodeName());

    }
}