public static Document toXhtml(String html) throws ParserConfigurationException {
    HtmlCleaner cleaner = new HtmlCleaner();
    TagNode tagNode = cleaner.clean(html);
    DomSerializer domSerializer = new DomSerializer(new CleanerProperties());
    return domSerializer.createDOM(tagNode);
}