import org.w3c.dom.*;
    import java.io.*;
    import javax.xml.parsers.DocumentBuilderFactory;
    import javax.xml.parsers.DocumentBuilder;

    File xmlFile = new File("/data/test/test.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(xmlFile);

    NodeList eventList = doc.getElementsByTagName("DEvent");
    for (int i=0; i< eventList.getLength(); i++) {
        Node thisNode = eventList.item(i);

        if(thisNode.hasChildNodes()){
            NodeList event = thisNode.getChildNodes().getFirstChild().getNextSibling();
            String eid = event.getAttributes().getNamedItem("eid");
            String value = event.getFirstChild().getNodeValue();
            System.out.println("EID: " + eid + " Value: " + value + "\n");
        }
    }