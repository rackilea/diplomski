NodeList nList = doc.getElementsByTagName("prop");
for (int i = 0, len = nList.getLength(); i < len; i++) {
    Element elm = (Element)nList.item(i);
    if (elm.getAttribute("name").contains("test")) {
        String connName = ((Element)elm.getParentNode()).getAttribute("name");
        // ...
    }
}