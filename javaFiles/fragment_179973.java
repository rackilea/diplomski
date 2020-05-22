public class LoginConsumerResponseParser extends DefaultHandler {
    public void startDocument() throws SAXException {
        System.out.println("startDocument()");
    }

    public void endDocument() throws SAXException {
        System.out.println("endDocument()");
    }

    public void startElement(String namespaceURI, String localName,
                             String qName, Attributes attrs) 
        throws SAXException {

        if (qName.equals("ActiveProdOwnership")) {
            inActiveProdOwnership = true;
        } else if (qName.equals("Product")) {
            if (!inActiveProdOwnership) {
                throw new SAXException("Product tag not expected here.");
            }
            int length = attrs.getLength();
            for (int i=0; i<length; i++) {
                String name = attrs.getQName(i);
                System.out.print(name + ": ");
                String value = attrs.getValue(i);
                System.out.println(value);            
            }
        }            
    }

    public void endElement(String namespaceURI, String localName, String qName)
        throws SAXException {

        if (localName.equals("ActiveProdOwnership"))
            inActiveProdOwnership = false;
    }

    public void characters(char ch[], int start, int length) {
    }

    public static void main(String args[]) throws Exception {
        String xmlFile = args[0];
        File file = new File(xmlFile);
        if (file.exists()) {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            DefaultHandler handler = new Test();
            parser.parse(xmlFile, handler);
        }
        else {
            System.out.println("File not found!");
        }
    }

    private boolean inActiveProdOwnership = false;
}