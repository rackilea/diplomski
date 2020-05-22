DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
documentBuilderFactory.setNamespaceAware(true);
DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
Document documentPtk = documentBuilder.parse(new InputSource(inputStream));
XPathFactory xPathFactory = XPathFactory.newInstance();
XPath xPath = xPathFactory.newXPath();

SimpleNamespaceContext nsCtx = new SimpleNamespaceContext();
nsCtx.bindNamespaceUri("p", "http://linkToNameSpace");
xPath.setNamespaceContext(nsCtx);

XPathExpression xPathExpression = xPath.compile("/p:PrintTalk/p:Request/p:PurchaseOrder/*");
Element documentXjdf = (Element) xPathExpression.evaluate(documentPtk, XPathConstants.NODE);