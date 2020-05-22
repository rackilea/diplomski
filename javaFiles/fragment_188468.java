DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);
    dbf.setIgnoringElementContentWhitespace(true);

    Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new File("schema1.xsd"));
    //dbf.setSchema(schema);

    DocumentBuilder db = dbf.newDocumentBuilder();

    Document doc = db.parse("file1.xml");

    System.out.println(doc.getDocumentElement().getChildNodes().getLength());