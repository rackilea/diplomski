private String parse(Document document) {
    Element root = document.getDocumentElement();
    NodeList queries = root.getElementsByTagName("queries");
    int queriesLength = queries.getLength();
    for (int i = 0; i < queriesLength; i++) {
        Element currentQuery = (Element) queries.item(i);
        if (currentQuery.getNodeType() == Element.ELEMENT_NODE) {
            String pagename = currentQuery.getAttributes()
                    .getNamedItem("pagename").getTextContent();
            String param = currentCategory.getAttributes()
                    .getNamedItem("param").getTextContent();
            if(param.equals(paramValue) && pagename.equals(pagename)){
               String query =  currnetNode.item(0).getTextContent();
                return query;
            }
            return null;
        }
    }
}