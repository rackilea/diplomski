StringBuilder buf = new StringBuilder();
int year;
int month;
int day;

@Override
public void startElement(String uri, String localName, String qName,
        Attributes attributes) throws SAXException {
    if (localName.equals("year")) {
        buf.setLength(0);
    } else if (localName.equals("month")) {
        buf.setLength(0);
    } else if (localName.equals("day")) {
        buf.setLength(0);
    }
}

@Override
public void endElement(String uri, String localName, String qName)
        throws SAXException {
    if (localName.equals("start-date")) {
       doSomethingWith(year,month,day);
    } else if (localName.equals("year")) {
        year = Integer.parseInt(buf.toString());
    } else if (localName.equals("month")) {
        month = Integer.parseInt(buf.toString());
    } else if (localName.equals("day")) {
        day = Integer.parseInt(buf.toString());
    }
}

@Override
public void characters(char chars[], int start, int length)
        throws SAXException {
    buf.append(chars, start, length);
}