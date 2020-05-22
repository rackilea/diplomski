public class parser implements ContentHandler {
    boolean check = false;
    ArrayList<String> queries = new ArrayList<>();

    public ArrayList<String> getQueries(String fileName) throws SAXException, IOException {
        XMLReader xmlReader = XMLReaderFactory.createXMLReader();
        xmlReader.setContentHandler(this);
        xmlReader.parse(fileName);
        return queries;
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void startDocument() throws SAXException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void endDocument() throws SAXException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
    switch (localName) {
        case "query":
            String param = atts.getValue("param");
            String pagename = atts.getValue("pagename");
            if(!param.isEmpty() && !pagename.isEmpty())
                check = true;
            break;
        default:
            return;
    }
}

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
            check = false;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String tagContent = new String(ch, start, length).trim();
        if(check){
            if(!tagContent.isEmpty()){
                queries.add(tagContent);
            }
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}