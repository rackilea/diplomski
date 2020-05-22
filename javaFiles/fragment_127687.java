String xml = "YourXMl"          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setNamespaceAware(true);
DocumentBuilder builder = factory.newDocumentBuilder();
InputSource is = new InputSource(new StringReader(xml));
Document doc = builder.parse(is);
NodeList nodes =  doc.getDocumentElement().getElementsByTagNameNS("x","id");
System.err.println(nodes.item(0).getChildNodes().item(0).getNodeValue());