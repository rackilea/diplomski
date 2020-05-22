@Override
//Triggered when the start of tag is found.
public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    content = null;
    if (qName.equals("link")) {
        lnk = new Link();
    }        
}