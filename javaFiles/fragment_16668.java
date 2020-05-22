public static void parseXML(Node node, Node parent)
{
   if (node.hasChildNodes())
   {
      System.out.println(node.getNodeName());
      NodeList childrens = node.getChildNodes();
      for (int i = 0; i < childrens.getLength(); i++)
      {
            parseXML(childrens.item(i), node);           
      }//for
   }//fi:root_childrens
   else {
      String nodeValue = node.getNodeValue().trim();
      if (nodeValue.length() > 0){
          System.out.println(parent.getNodeName() + "::" + nodeValue);
      }

   }
}