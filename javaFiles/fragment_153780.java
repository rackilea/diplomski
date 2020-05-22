import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//given that the doc is your xml file
public NodeList getMainInfo(Document doc) {
    NodeList feed = doc.getElementsByTagName("powerplay");
    Node feedElement = feed.item(0);
    NodeList info = feedElement.getChildNodes();
    return info;
}

public String getPPG(NodeList info){
    Element powerplay = (Element) info;
    return info.getAttribute("ppg");
}

public String getPPOPP(NodeList info){
    Element powerplay = (Element) info;
    return info.getAttribute("ppopp");
}