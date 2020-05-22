// Use like so:
Node metadatanode = metadata.getAsTree(metadataname);

String xmp_xml = XMPExample.getXMP((Element) metadatanode);

// xmp_xml is now an xml document STRING
System.out.print(xmp_xml);

// If you want to parse it as an XML document, use an XML parser.
Document xmp_dom = XMPExample.transformXML(xmp_xml);

// ...and you can serialize it again when you are done.
String xmp_xml_roundtripped = XMPExample.transformXML(xmp_dom);