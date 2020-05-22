DOMImplementation impl =
    textContentBody.getOwnerDocument().getImplementation();
DOMImplementationLS ls =
    (DOMImplementationLS) impl.getFeature("+LS", "3.0");
LSSerializer serializer = ls.createLSSerializer();
serializer.getDomConfig().setParameter("xml-declaration", false);
String contentData = serializer.writeToString(textContentBody);