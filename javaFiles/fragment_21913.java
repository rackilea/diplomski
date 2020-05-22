private boolean isDescStarted = false;

private StringBuilder textDesc = new StringBuilder();

public void startElement(String uri, String name, String qName, Attributes atts) {
   if(name.equals("desc") {isDescStarted = true;}
}

public void endElement(String uri, String name, String qName) {
   if(name.equals("desc") {
      isDescStarted = false;
      String fullTextDesc = textDesc.toString(); // do whatever you want with this string now
   }
}

public void characters(char[] buf, int offset, int length) {
   if (isDescStarted) {
      textDesc.append(new String(buf, offset, length));
   }
}