OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(stream);
OMElement documentElement = builder.getDocumentElement();
Iterator it = documentElement.getChildrenWithName(new QName("http://namespace", "elementName"));
if (it.hasNext()) {
    it.next();
    it.remove();
}