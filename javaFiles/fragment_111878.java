public void getTagRss(String URL) {
    XMLParser parser = new XMLParser();
    String xml = getXml(URL);
    Document doc = parser.getDomElement(xml);
    NodeList nl = doc.getElementsByTagName(Rss_key); // Site tag Name
    for (int i = 0; i < nl.getLength(); i++) {
        Element e = (Element) nl.item(i);
        NodeList children = e.getElementsByTagName(Item_key);
        for (int j = 0; j < children.getLength(); j++) {
            Element C1 = (Element) children.item(j);
            RssObject Value = new RssObject();
            Value.Title = parser.getValue(C1, Title_key);
            Value.Desc = parser.getValue(C1, Desc_key);
            Gen_Obj.Rsslist2.add(Value);
        }
    }
}