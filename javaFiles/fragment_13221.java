public <I, T extends DefaultHandler & RSSLister<I>> List<I> getItems(Class<T> handlerClass) throws Exception {
    SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
    SAXParser saxParser = saxParserFactory.newSAXParser();
    T handler = handlerClass.newInstance();
    saxParser.parse("https://www.scoopwhoop.com/rss/category/news", handler);
    return handler.getRSSItemList();
}