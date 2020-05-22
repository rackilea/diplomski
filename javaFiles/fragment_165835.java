public static int getElementIndex(Element original) {
  int count = 1;

  for (Node node = original.getPreviousSibling(); node != null;
       node = node.getPreviousSibling()) {
    if (node instanceof Element) {
      Element element = (Element) node;
      if (element.getTagName().equals(original.getTagName()) {
        count++;
      }
    }
  }

  return count;
}