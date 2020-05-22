throws SAXException, IOException, XPathExpressionException {
    DocumentBuilderFactory builderFactory = DocumentBuilderFactory
            .newInstance();
    DocumentBuilder builder = null;
    try {
        builder = builderFactory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    }
    Document xmlDocument = builder.parse(new ByteArrayInputStream(employeeXml
            .getBytes()));
    XPath xPath = (XPath) XPathFactory.newInstance().newXPath();
    String expression = "/Employee/EmpDetails/Name";
    String empName = xPath.compile(expression).evaluate(
            xmlDocument);
    return empName;