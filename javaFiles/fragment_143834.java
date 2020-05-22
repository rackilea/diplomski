public class Main {

    public static void main(String[] args) throws Exception {
        File xmlDocument = new File("e://journal_last.xml");
        FileInputStream xmlInputStream = new FileInputStream(xmlDocument);

        Document doc = parseDocument(new InputSource(xmlInputStream));
        NodeList articleList = evaluateXPath(doc, "/journal/articleset",
                NodeList.class);
        String xmlString = writeXmlString(articleList);

        System.out.println(xmlString);

    }

    private static Document parseDocument(InputSource inputSource)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = documentBuilderFactory
                .newDocumentBuilder();
        Document doc = docBuilder.parse(inputSource);
        return doc;
    }

    @SuppressWarnings("unchecked")
    private static <T> T evaluateXPath(Document doc, String xpath,
            Class<T> resultType) throws XPathExpressionException {
        QName returnType = resolveReturnType(resultType);

        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();
        XPathExpression xpathExpression = xPath.compile(xpath);

        Object resultObject = xpathExpression.evaluate(doc, returnType);
        return (T) resultObject;
    }

    private static QName resolveReturnType(Class<?> clazz) {
        if (NodeList.class.equals(clazz)) {
            return XPathConstants.NODESET;
        } else {
            throw new UnsupportedOperationException("Not implemented yet");
        }
    }

    private static String writeXmlString(NodeList nodeList)
            throws TransformerConfigurationException,
            TransformerFactoryConfigurationError, TransformerException {

        StreamResult streamResult = new StreamResult(new StringWriter());
        TransformerFactory transformerFactory = TransformerFactory
                .newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node articleListItem = nodeList.item(i);
            DOMSource source = new DOMSource(articleListItem);
            transformer.transform(source, streamResult);
        }

        String xmlString = streamResult.getWriter().toString();
        return xmlString;
    }
}