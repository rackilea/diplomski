// somewhere before:
Writer underlyingWriter = /* get the underlying writer from somewhere */;
XMLStreamWriter xmlStreamWriter = factory.createXmlStreamWriter(underlyingWriter);

xmlStreamWriter.flush();
underlyingWriter.write(rawXML);
underlyingWriter.flush();
// carry on using the XMLStreamWriter