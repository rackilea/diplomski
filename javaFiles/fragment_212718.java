StringBuilder builder;

public void startElement(String uri, String localName, String qName, Attributes atts) {
   builder = new StringBuilder();
}

public void characters(char[] ch, int start, int length) {
   builder.append(ch,start,length);
}

public void endElement(String uri, String localName, String qName) {
  String theFullText = builder.toString();
}