public void endElement(String uri, String localName, String qName)
        throws SAXException {

    //...           
    //Reset 'chars' length at the end always.
    chars.setLength(0);
    }