// creating the "actual" node I want to test (nothing changed here)
Node xmlNodeActual = XmlUtils.marshaltoW3CDomDocument(actual).getDocumentElement();

//...

// Instead of parsing the string, just unmarshal and marshal it once
Object expected = XmlUtils.unmarshal(new ByteArrayInputStream(strXmlNode.getBytes("utf-8")));
Node xmlNodeExpected = XmlUtils.marshaltoW3CDomDocument(expected).getDocumentElement();
if(!xmlNodeActual.isEqualNode(xmlNodeExpected)) {
// ...
}