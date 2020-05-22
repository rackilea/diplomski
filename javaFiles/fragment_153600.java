XPathFactory f = XPathFactory.newInstance();
    XPathExpression expr = f.newXPath().compile(
            "//*[local-name() = 'FindME']/text()");
    DocumentBuilderFactory domFactory = DocumentBuilderFactory
            .newInstance();
    domFactory.setNamespaceAware(true);
    DocumentBuilder builder = domFactory.newDocumentBuilder();
    Document doc = builder.parse("src/test.xml"); //your XML file

    Object result = expr.evaluate(doc, XPathConstants.NODESET);
    NodeList nodes = (NodeList) result;
    System.out.println(nodes.getLength());
    for (int i = 0; i < nodes.getLength(); i++) {
        System.out.println(nodes.item(i).getNodeValue());
    }