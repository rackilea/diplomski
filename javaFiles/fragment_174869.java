DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
InputStream is = MyServlet.getClass().getResourceAsStream("/path/to/my/example.xml");
Document document = documentBuilder.parse(new InputSource(is));
// And start exploring the NodeList...
NodeList nodeList = document.getFirstChild().getChildNodes();