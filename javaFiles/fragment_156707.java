DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
Document doc = dBuilder.parse(bais);
doc.getDocumentElement().normalize();
NodeList nList = doc.getElementsByTagName("return");
for (int i=0;i<nList.getLength();i++) {
   Node nNode = nList.item(i);
   if (nNode.getNodeType() == Node.ELEMENT_NODE) {
      Element curElement = (Element) nNode;
      int id = Integer.parseInt(curElement.getElementsByTagName("id").item(0).getTextContent()); 
      String value = curElement.getElementsByTagName("value").item(0).getTextContent();   
   }
}