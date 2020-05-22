NodeList nodes = (NodeList)xpath.evaluate("Actor", movieNode, XPathConstants.NODESET);
for (int i = 0; i < nodes.getLength(); i++) {
  Element actor = (Element)nodes.item(i);
  String actorName = actor.getTextContent();
  String character = actor.getAttribute("Character");
  System.out.println("Starring: " + actorName + " as " + character + "\n");
}