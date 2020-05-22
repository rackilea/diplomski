public static Document getWebpageDocument_fromSource(String source) throws InterruptedException, IOException {
    try {
        HtmlCleaner cleaner = new HtmlCleaner();
        CleanerProperties props = cleaner.getProperties();
        props.setAllowHtmlInsideAttributes(true);
        props.setAllowMultiWordAttributes(true);
        props.setRecognizeUnicodeChars(true);
        props.setOmitComments(true);

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        TagNode tagNode = new HtmlCleaner().clean(source);

        Document doc = new DomSerializer(new CleanerProperties()).createDOM(tagNode);

        return doc;
    } catch (ParserConfigurationException ex) {
        ex.printStackTrace();
        return null;
    }
}