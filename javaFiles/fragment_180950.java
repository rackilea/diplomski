String startName;

public void startElement(String uri, String localName,
String qName, Attributes attributes)
throws SAXException {
startName=qName;
}

public void characters(char ch[], int start, int length) 
 {
      //here check what the startName is.It can be rating or Num
      String value = new String(ch,start,length);
 }