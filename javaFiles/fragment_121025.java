String xml = "<root><element>test</element></root>";
XMLInputFactory xmlif = XMLInputFactory.newInstance();
XMLStreamReader xmlr = xmlif.createXMLStreamReader(new StringReader(xml));
while (xmlr.hasNext()) {
    xmlr.next();
    if (xmlr.isStartElement() || xmlr.isEndElement()) {
        System.out.println(xmlr.getLocalName() + " " + xmlr.getEventType());
    }
}