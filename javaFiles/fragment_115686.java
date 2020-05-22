DocumentBuilderFactory builderFactory =DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = builderFactory.newDocumentBuilder();
    Document document = builder.parse(new InputSource(new StringReader(xml)));

    XPath xpath = XPathFactory.newInstance().newXPath();
    String expression="//*[(@key='')or(string(@key))]"; 

    Set<String> towns=new HashSet<String>();

    XPathExpression expr = xpath.compile(expression) ; 
    NodeList nodes  = (NodeList) expr.evaluate(document, XPathConstants.NODESET);