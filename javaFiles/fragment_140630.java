StringBulder xmlText = new StringBuilder();

 public void characters(char buf[], int offset, int len) throws SAXException
 {
    xmlText.append(buf, offset, len);

}

public void endElement(String uri, String localName, String qname) throws SAXException 
{
    System.out.println(xmlText.toString());
    xmlText = new StringBuilder();
}