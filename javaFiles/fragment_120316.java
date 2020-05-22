final String dtd = "/path/to/the/dtd_file.dtd"; 
builder.setEntityResolver(new EntityResolver() {
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        if (systemId.endsWith("something.dtd")) {
            return new InputSource(new FileInputStream(dtd));
        }
        return null;
    }
});