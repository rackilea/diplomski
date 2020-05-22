DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setNamespaceAware(true);
dbf.setValidating(true);
DocumentBuilder db = dbf.newDocumentBuilder();
db.setEntityResolver(new EntityResolver()
{
    public InputSource resolveEntity(String publicId, String systemId)
        throws SAXException, IOException
    {
        return new InputSource(new StringReader(dtd));
    }
});