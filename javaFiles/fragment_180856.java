public static String textPlus(Element elem)
   {
      List<TextNode> textNodes = elem.textNodes();
      if (textNodes.isEmpty())
         return "";

      StringBuilder result = new StringBuilder();
      // start at the first text node
      Node currentNode = textNodes.get(0);
      while (currentNode != null)
      {
         // append deep text of all subsequent nodes
         if (currentNode instanceof TextNode)
         {
            TextNode currentText = (TextNode) currentNode;
            result.append(currentText.text());
         }
         else if (currentNode instanceof Element)
         {
            Element currentElement = (Element) currentNode;
            result.append(currentElement.text());
         }
         currentNode = currentNode.nextSibling();
      }
      return result.toString();
   }