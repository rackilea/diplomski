DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

 DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
 InputStream inputStream = new ByteArrayInputStream(XML.getBytes());
 Document parsed = db.parse(inputStream);

 parsed.getDocumentElement().normalize();
 Node tag = parsed.getElementsByTagName("jfs:jauthSigninUrl").item(0);
 String value = tag.getAttributes().getNamedItem("rdf:resource").getNodeValue();