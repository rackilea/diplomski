Processor p = new net.sf.saxon.s9api.Processor();
Serializer s = p.newSerializer();
s.setOutputProperty(Property.METHOD, "xml");
s.setOutputProperty(Property.INDENT, "yes");
s.setOutputStream(....);
XMLStreamWriter writer = s.getXMLStreamWriter();