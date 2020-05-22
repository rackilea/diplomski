private NamespaceContext ns = new NamespaceContext() {
public String getNamespaceURI(String prefix) {
if (prefix.equals("urn") return "urn:soap.sof.com";
else return XMLConstants.NULL_NS_URI;
}
public String getPrefix(String namespace) {
throw new UnsupportedOperationException();
}
public Iterator getPrefixes(String namespace) {
throw new UnsupportedOperationException();
}};

XPathFactory xpfactory = XPathFactory.newInstance();
XPath xpath = xpfactory.newXPath();
xpath.setNamespaceContext(ns);
NodeList nodes = (NodeList) xpath.evaluate("//urn:userInfo|//userInfo", myDom, XPathConstants.NODESET);
//find all userInfo at any depth with either namespace.