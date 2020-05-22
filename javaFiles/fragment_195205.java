public class MyHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("---=== Report ===---");
    }
    @Override
    public void endDocument() throws SAXException {
        System.out.println("---=== End of Report ===---");
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("van")) {
            System.out.println("Van (" + attributes.getValue("id") + ")");
            System.out.println("    Customers");
        }
        if (qName.equalsIgnoreCase("cart")) {
            System.out.println("Cart (" + attributes.getValue("id") + ")");
            System.out.println("    Customers");
        }
        if (qName.equalsIgnoreCase("customer")) {
            System.out.println("        " + attributes.getValue("lastName") + ", " + attributes.getValue("firstName") + " at " + attributes.getValue("streetAddress") + ", " + attributes.getValue("zipCode"));
        }
    }
}