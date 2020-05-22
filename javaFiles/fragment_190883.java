NodeList list = yourNodeList.getChildNodes();
for (int i = 0; i < list.getLength(); i++) {

     Node node = list.item(i);
     if ("result".equals(node.getNodeName())) 
     {
        node.setTextContent("your_value");
     }
}