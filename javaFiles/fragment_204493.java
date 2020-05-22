if(currentNode.getNodeName().equals("firstName"))
{
   Node textNode = currentNode.getFirstChild();
   System.out.println("Initial value:" + textNode.getNodeValue());
   String nodeValue="salma";
   textNode.setNodeValue(nodeValue);
   System.out.println("Modified value:" + textNode.getNodeValue());
}