private boolean inTypeTag = false;

public void startElement(String uri, String localName, String qName, ...) ...{
    if (qName.equals("type") {
        inTypeTag = true;
    }
    ...
}

public void endElement(String uri, String localName, String qName, ...)  ...{
    if (qName.equals("type") {
        inTypeTag = false;
    }
    ...
}

public void characters(char ch[], int start, int length) ... {
    if (inTypeTag) {
        // do something with the text ("sport") which was found in here
    }
    ...
}