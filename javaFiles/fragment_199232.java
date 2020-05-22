public CustomStreamWriter ([...], Writer writer) throws XMLStreamException {
    this([...], XMLOutputFactory.newInstance().createXMLStreamWriter(writer);
}

protected CustomStreamWriter ([...], XMLStreamWriter outputHandler) {
    this.writer = writer;
}