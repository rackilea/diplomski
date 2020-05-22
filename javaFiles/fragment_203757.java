DocumentBuilder builder = factory.newDocumentBuilder();
Document readLib = builder.parse(LIBRARY_FILE_PATH);
XPathFactory xPathfactory = XPathFactory.newInstance();
XPath xpath = xPathfactory.newXPath();
XPathExpression expr = xpath.compile("//Playlist[@id='" + id + "']/Game");

System.out.println("ID:" + id);
NodeList gameNodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
//the rest can be the same code
.......