public class MyHandler extends DefaultHandler implements LexicalHandler {

    private String currentEntity = null;

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String content = new String(ch, start, length);
        if (currentEntity != null) {
            content = "&" + currentEntity + content;
            currentEntity = null;
        }
        System.out.print(content);
    }

    @Override
    public void startEntity(String name) throws SAXException {
        currentEntity = name;
    }

    @Override
    public void endEntity(String name) throws SAXException {
    }

    @Override
    public void startDTD(String name, String publicId, String systemId)
            throws SAXException {
    }

    @Override
    public void endDTD() throws SAXException {
    }

    @Override
    public void startCDATA() throws SAXException {
    }

    @Override
    public void endCDATA() throws SAXException {
    }

    @Override
    public void comment(char[] ch, int start, int length) throws SAXException {
    }
}