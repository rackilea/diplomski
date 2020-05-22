List songElements = doc.getRootElement().getChildren("song");

for(int i = 1 ; i <= songElements.size() ; i++) {
   Element songElement = (Element) songElements.get(i);
   String name = songElement.getAttributeValue("name");
   String path = songElement.getAttributeValue("path");
   String album = songElement.getAttributeValue("album");
}