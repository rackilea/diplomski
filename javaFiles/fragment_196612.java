xPath.setNamespaceContext(new NamespaceContext() {
    public String getNamespaceURI(String prefix) {
        if (prefix.equals("SOAP-ENV")) {
            return "http://schemas.xmlsoap.org/soap/envelope/";
        } else if (prefix.equals("v4")) {
            return "http://fedex.com/ws/track/v4";
        } else {
            return XMLConstants.NULL_NS_URI;
        }
    }
    public String getPrefix(String namespaceURI) { return null;}
    public Iterator getPrefixes(String namespaceURI) { return null;}
});