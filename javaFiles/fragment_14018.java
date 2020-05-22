for (int j = 0; j < filesNodeList.getLength(); j++) {
  Element fileElement = (Element) filesNodeList.item(j);
  if (!fileElement.getParentNode().getNodeName().equals("notification")) {
    continue;
  }
  ...
}