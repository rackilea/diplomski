for (int i = 0; i < list.getLength(); i++) {
    Element element = (Element) list.item(i);
    String nodnam = element.getNodeName();

    if (element.getChildNodes().getLength() > 0) // then it has text
    {
    // etc., etc.