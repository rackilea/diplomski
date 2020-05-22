NodeList customerNodes = skeleton.getElementsByTagName("customerAttributes");
for (int i = 0; i < customerNodes.getLength(); i++) {
    NodeList children = customerNodes.item(i).getChildNodes();
    for (int j = 0; j < children.getLength(); j++) {
        String childNode = children.item(j).getNodeName();
        if (childNode.equalsIgnoreCase("firstName")) {
            children.item(j).setTextContent(String.valueOf(params.get("fname")));
        }
        else if (childNode.equalsIgnoreCase("lastName")) {
            children.item(j).setTextContent(String.valueOf(params.get("sname")));
        }
    }  
}