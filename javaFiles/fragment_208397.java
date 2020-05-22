class CustomErrorHandler implements ErrorHandler {
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println(e.toString());
    }

    public void error( SAXParseException e ) throws SAXException {
        System.out.println(e.toString());
    }

    public void warning( SAXParseException e ) throws SAXException {
        System.out.println(e.toString());
    }
}