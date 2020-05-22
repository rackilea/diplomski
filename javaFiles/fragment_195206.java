public class MyHandler extends DefaultHandler {
    private boolean firstCustomer;
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
            firstCustomer = true;
        }
        if (qName.equalsIgnoreCase("cart")) {
            System.out.println("Cart (" + attributes.getValue("id") + ")");
            firstCustomer = true;
        }
        if (qName.equalsIgnoreCase("customer")) {
            if (firstCustomer) {
                firstCustomer = false;
                System.out.println("    Customers");
            }
            System.out.println("        " + attributes.getValue("lastName") + ", " + attributes.getValue("firstName") + " at " + attributes.getValue("streetAddress") + ", " + attributes.getValue("zipCode"));
        }
    }
}