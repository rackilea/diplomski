NCPDPReader ncpdpReader = new NCPDPReader(serializationSegmentDelimiter, serializationGroupDelimiter, serializationFieldDelimiter);
StringWriter stringWriter = new StringWriter();
XMLPrettyPrinter serializer = new XMLPrettyPrinter(stringWriter);
ncpdpReader.setContentHandler(serializer);
ncpdpReader.parse(new InputSource(new StringReader(source)));
return stringWriter.toString();