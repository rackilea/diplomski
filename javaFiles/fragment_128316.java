DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setNamespaceAware(true);

Document doc;
try (InputStream xmlStream = new FileInputStream(PATH_TO_MY_XML)) {
    doc = dbf.newDocumentBuilder().parse(xmlStream);
}
NodeList nodes = doc.getDocumentElement().getElementsByTagNameNS("*", "UBLExtension");