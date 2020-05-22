private ArrayList<String> questionList;
private boolean questionBuffering;
private StringBuilder sb;



@Override
public void startDocument() throws SAXException {
questionList = new ArrayList<String>();
} 

@Override
public void endDocument() throws SAXException {
} 

@Override
public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
    if (localName.equals("question")) {
        questionBuffering = true;
    }

}


@Override
public void characters(char ch[], int start, int length) {
    if(questionBuffering) {
        sb.append(ch, start, length);
    }

} 

@Override
public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
    if (localName.equals("question")) {
        questionBuffering = false;
    questionList.add(sb.toString());
    }
}

public ArrayList<String> getResult() {
    return questionList;
    };
}