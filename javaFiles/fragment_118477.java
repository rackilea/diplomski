void parseStringWithSAX (String xmlString, ContentHandler handler)
    throws TransformerConfigurationException, TransformerException  {
    Source source = new StreamSource (new StringReader (xmlString));
    Result result = new SAXResult (handler);
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer t = tf.newTransformer();
    t.transform(source, result);
}