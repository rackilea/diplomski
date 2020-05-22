public static String getInnerHTML(Node node) throws TransformerConfigurationException, TransformerException
{
    StringWriter sw = new StringWriter();
    Result result = new StreamResult(sw);
    TransformerFactory factory = new net.sf.saxon.TransformerFactoryImpl();
    Transformer proc = factory.newTransformer();
    proc.setOutputProperty(OutputKeys.METHOD, "html");
    for (int i = 0; i < node.getChildNodes().getLength(); i++)
    {
        proc.transform(new DOMSource(node.getChildNodes().item(i)), result);
    }
    return sw.toString();
}