public final class StringURIResolver implements URIResolver {
    Map<String, String> documents = new HashMap<String, String>();

    public StringURIResolver put(final String href, final String document) {
        documents.put(href, document);
        return this;
    }

    public Source resolve(final String href, final String base)
    throws TransformerException {
        final String s = documents.get(href);
        if (s != null) {
            return new StreamSource(new StringReader(s));
        }
        return null;
    }
}