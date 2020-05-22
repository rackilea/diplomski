public class parser implements ContentHandler {
    boolean check = false;
    ArrayList<String> queries = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        switch (localName) {
            case "query":
                String param = atts.getValue("param");
                String pagename = atts.getValue("pagename");
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