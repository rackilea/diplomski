public String getXMLValue(String xml, String searchNodes) {
    String retVal = "";
    String[] nodeSplit = searchNodes.split("/");

    try 
    {  
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc;
        NodeList nList;

        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.parse( new InputSource( new StringReader( xml )) );

        nList = doc.getElementsByTagName(nodeSplit[0]);
        retVal = GetNode(nList, searchNodes, 0);
    } catch (Exception e) {  
        e.printStackTrace();  
    } 

    return retVal;
}

public String GetNode(NodeList nl, String searchNodes, int item)
{
    String retVal = null;
    String findNode = searchNodes.split("/")[item];
    int count = searchNodes.split("/").length;

    item++;

    for(int i=0; i<nl.getLength(); i++) {
        String foundNode = nl.item(i).getNodeName();
        NamedNodeMap nnm = nl.item(i).getAttributes();
        if(nnm!=null && nnm.getLength()>0 && count>item) {
            Node attribute = nnm.getNamedItem(searchNodes.split("/")[item]);
            if(attribute!=null) {
                retVal = attribute.getTextContent();
                break;
            }
        }

        if(foundNode.equals(findNode) && count>item) {
            retVal = GetNode(nl.item(i).getChildNodes(), searchNodes, item);
            break;
        } else if(foundNode.equals(findNode) && count==item) {
            retVal = nl.item(i).getTextContent(); 
            break;
        }
    }

    return retVal;
}