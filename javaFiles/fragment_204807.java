private static class EntityResolver2Impl implements EntityResolver2 {
    private File xmlFile;
    public EntityResolver2Impl(File xmlFile) {
        this.xmlFile = xmlFile;
    }

    @Override
    public InputSource getExternalSubset(String name, String baseURI) throws SAXException, IOException {
        return null;
    }

    @Override
    public InputSource resolveEntity(String name, String publicId, String baseURI, String systemId) throws SAXException, IOException {
        File entityPath = new File(xmlFile.getParent(), systemId);
        return new InputSource(new FileReader(entityPath));
    }

    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        return null;
    }
}