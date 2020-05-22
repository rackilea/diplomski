URL xsdUrlA = this.getClass().getResource("a.xsd");
URL xsdUrlB = this.getClass().getResource("b.xsd");
URL xsdUrlC = this.getClass().getResource("c.xsd");

SchemaFactory schemaFactory = schemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//---
String W3C_XSD_TOP_ELEMENT =
"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
   + "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" elementFormDefault=\"qualified\">\n"
   + "<xs:include schemaLocation=\"" +xsdUrlA.getPath() +"\"/>\n"
   + "<xs:include schemaLocation=\"" +xsdUrlB.getPath() +"\"/>\n"
   + "<xs:include schemaLocation=\"" +xsdUrlC.getPath() +"\"/>\n"
   +"</xs:schema>";
Schema schema = schemaFactory.newSchema(new StreamSource(new StringReader(W3C_XSD_TOP_ELEMENT), "xsdTop"));