NodeList elements = document.getElementsByTagName("*");
Set<String> nodesNames = new LinkedHashSet<>();
for (int i = 0; i < elements.getLength(); i++) {
      Node node = elements.item(i);
      NodeList nodeList = node.getChildNodes();
      for (int j = 0; j < nodeList.getLength(); j++) {
            Node currentNode = nodeList.item(j);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                 nodesNames.add(node.getParentNode().getNodeName());
                 break;
            }
      }
}
System.out.println("nodesNames = " + nodesNames);