dBuilder.setEntityResolver(new EntityResolver() {
    @Override
    public InputSource resolveEntity(String publicID,
                                     String systemID)
    throws SAXException,
           IOException {

        if (systemID.startsWith("jar:") && !systemID.contains("!/")) {
            String path = systemID.replaceFirst("^jar:/*", "/");
            return new InputSource(ParseXML.class.getResourceAsStream(path));
        }
        return null;
    }
});