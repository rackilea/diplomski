private static String toString(Node n) throws TransformerFactoryConfigurationError, TransformerException {
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    StreamResult result = new StreamResult(new StringWriter());
    DOMSource source = new DOMSource(n);
    transformer.transform(source, result);
    return result.getWriter().toString();
}