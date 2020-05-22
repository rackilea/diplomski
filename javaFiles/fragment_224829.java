class ClasspathResourceURIResolver implements URIResolver {

    @Override
    public Source resolve(String href, String base) throws TransformerException {
        return new StreamSource(this.getClass().getClassLoader().getResourceAsStream(href));
}