/** my resolver that doesn't */
private static class NullEntityResolver implements EntityResolver {

    public InputSource resolveEntity(String publicId, String systemId) 
    throws SAXException, IOException {
        // Message only for debugging / if you care
        System.out.println("I'm asked to resolve: " + publicId + " / " + systemId);
        return new InputSource(new ByteArrayInputStream(new byte[0]));
    }

}