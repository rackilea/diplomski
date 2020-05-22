import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

NodeList nList = d.getElementsByTagName("ecs:Person");

for (int temp = 0; temp < nList.getLength(); temp++) 
    {
    Node nNode = nList.item(temp);
    if (nNode.getNodeType() == Node.ELEMENT_NODE)
       {
       Element eElement = (Element) nNode;