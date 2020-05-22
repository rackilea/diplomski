public void marshal(Object obj, OutputStream out, NamespaceContext inscopeNamespace) throws JAXBException {
    write(obj, createWriter(out), new StAXPostInitAction(inscopeNamespace,serializer));
}

public void marshal(Object obj, XMLStreamWriter writer) throws JAXBException {
    write(obj, XMLStreamWriterOutput.create(writer,context), new StAXPostInitAction(writer,serializer));
}