DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document doc = db.parse(f);
Element root = doc.getDocumentElement();
NodeList nodeList = doc.getElementsByTagName("player");
for (int i = 0; i < nodeList.getLength(); i++) {
  Node node = nodeList.item(i);
  // do your stuff
}