List<Element> elements = new ArrayList<Element>();
List<String> tags = new ArrayList<String>();
List<String> texts = new ArrayList<String>();

NodeList c = doc.getElementsByTagName("c");
for (int i = 0; i < c.getLength(); i++) {
  if (c.item(i) instanceof Element) {
    NodeList children = c.item(i).getChildNodes();

    for (int j = 0; j < children.getLength(); j++) {
      if (children.item(j) instanceof Element) {
        elements.add((Element) children.item(j));
        tags.add(((Element) children.item(j)).getTagName());
        texts.add(children.item(j).getTextContent());
      }
    }
  }
}