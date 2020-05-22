public static void main(String... args)
        throws Exception
{
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(new ByteArrayInputStream(xml.getBytes()));

    XPathFactory xPathfactory = XPathFactory.newInstance();
    XPath xpath = xPathfactory.newXPath();

    // Find word elements with ExposureSentence attribute
    XPathExpression query = xpath.compile("//word[@ExposureSentence]");
    NodeList words = (NodeList) query.evaluate(doc, XPathConstants.NODESET);
    for (int i = 0; i < words.getLength(); i++) {
        // Remove the attribute
        ((Element) words.item(i)).removeAttribute("ExposureSentence");
    }

    // Handle ComponentName
    query = xpath.compile("//ComponentName");
    NodeList componentNames = (NodeList) query.evaluate(doc, XPathConstants.NODESET);
    for (int i = 0; i < componentNames.getLength(); i++) {
        String content = componentNames.item(i).getTextContent();
        componentNames.item(i).setTextContent(
            Arrays.stream(content.split(","))
                .map(String::trim)
                .filter(s -> !s.equals("ExposureSentence"))
                .collect(Collectors.joining(", ")));
    }

    // Omitted: Save the XML
}