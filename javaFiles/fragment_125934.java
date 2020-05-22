InputStream xml = // …
InputStream xsd = // …

SchemaFactory xsFact = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
Schema schema = xsFact.newSchema(new StreamSource(xsd));

DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setNamespaceAware(true);
dbf.setValidating(false);
dbf.setSchema(schema);
DocumentBuilder db = dbf.newDocumentBuilder();

Document dom = db.parse(new InputSource(xml));