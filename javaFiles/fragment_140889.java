//process each item node
Node node = nodeList.item(i);
if (node.getNodeName().equals("item")) {
    NamedNodeMap attributes = node.getAttributes();
    System.out.printf("id=%s, name=%s%n", 
            attributes.getNamedItem("id").getTextContent(),
            attributes.getNamedItem("name").getTextContent());
}