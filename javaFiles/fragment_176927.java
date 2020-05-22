@Override
public void endElement(String namespaceURI, String localName, String qName) throws SAXException {

}

@Override
public void characters(char ch[], int start, int length) {
    if (this.in_First_name) {
        this.in_First_name = false;
        myParsedDataSet.setfirstname(new String(ch, start, length));
    }
    if (this.in_Last_name) {
       this.in_Last_name = false;
       myParsedDataSet.setlastname(new String(ch, start, length));
    }
}