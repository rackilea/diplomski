xpath.setNamespaceContext(new NamespaceContext() {

    @SuppressWarnings("rawtypes")
    @Override
    public Iterator getPrefixes(final String namespaceURI) {
        return Collections.singleton("ns1").iterator();
    }

    @Override
    public String getPrefix(final String namespaceURI) {
        return "ns1";
    }

    @Override
    public String getNamespaceURI(final String prefix) {
        return "http://www.sea.com";
    }
});