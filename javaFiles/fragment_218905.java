// input is an InputSource or a DOM node
NodeList nl = (NodeList) xpath.evaluate("//Element1/@*", input, XPathConstants.NODESET);
int length = nl.getLength();
for( int i=0; i<length; i++) {
    Attr attr = (Attr) nl.item(i);
    String name = attr.getName();
    String value = attr.getValue();
}