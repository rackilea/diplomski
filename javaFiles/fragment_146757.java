public ByteArrayOutputStream merge(final InputStream file1,final InputStream file2) {
final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
final TransformerFactory tFactory = TransformerFactory.newInstance();
Transformer transformer;
try {
    transformer = tFactory.newTransformer(new StreamSource("merge.xslt"));
    final DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    final Document documentFile = db.parse(file2);
    Map<String, Document> docs = new HashMap<String, Document>();
    docs.put("lookup", documentFile);
    transformer.setURIResolver(new DocURIResolver(docs));
    transformer.transform(new StreamSource(file1), new StreamResult(outputStream));
} catch (final TransformerConfigurationException e) {
    LOG.warn("Problem occurred transforming files configuration issue", e);
} catch (final TransformerException e) {
    LOG.warn("Problem occurred transforming files", e);
}
return outputStream;
}