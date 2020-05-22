private StringBuffer buffer = new StringBuffer();

public void endElement(String uri, String localName,
       String qName)
       throws SAXException {

     if (qName.equalsIgnoreCase("title")) {
        System.out.println("title: " + buffer);
     }else if (qName.equalsIgnoreCase("description")) {
        System.out.println("description: " + buffer);
     }
     buffer = new StringBuffer();
}

public void characters(char ch[], int start, int length)
      throws SAXException {
     buffer.append(new String(ch, start, length));
}