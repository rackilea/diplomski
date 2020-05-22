public static void parseTags (Node node, List<Node> list)
{
      NodeList nodeList = node.getChildNodes();
      for (int i = 0; i < nodeList.getLength(); i++)
      {
           Node n = nodeList.item(i);
           if (n.getNodeType() == Node.ELEMENT_NODE)
           {
               String content = n.getTextContent();

               // if the tag content matches your criteria, add it to the list
               if (content.matches("/server[^<]*"))
               {
                   list.add(n);
               }
               parseTags(n, list);
           }
      }
}