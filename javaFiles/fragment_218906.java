NamedNodeMap nl = element.getAttributes();
int length = nl.getLength();
for( int i=0; i<length; i++) {
    Attr attr = (Attr) nl.item(i);
    String name = attr.getName();
    String value = attr.getValue();
}