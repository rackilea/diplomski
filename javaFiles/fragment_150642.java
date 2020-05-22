StringBuilder textContent = new StringBuilder();

public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
    tagName = qName;
    textContent.setLength(0);
}
public void characters(char ch[], int start, int length) throws SAXException {
    textContent.append(ch, start, length);
}
public void endElement(String uri, String localName, String qName) throws SAXException {
    String text = textContent.toString();
    // handle text here
}