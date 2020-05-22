NodeList nodes = doc.getElementsByTagName("assets").item(0).getChildNodes();
for ( int x = 0; x < nodes.getLength(); x++ ) {
    Node node = nodes.item(x);
    if (node.getNodeType() == Node.TEXT_NODE) {
        System.out.println(x + " text");
    } else if (node.getNodeType() == Node.ELEMENT_NODE) {
        String nodeName = node.getNodeName();

        System.out.println(x + " Node: " + nodeName);
    }
}