for (int i = 0; i < nodeList.getLength(); i++) {
    Element elem = (Element) nodeList.item(i);
    String attribute = elem.getAttribute("name");
    if ("HTTP-Method".equals(attribute) || "HTTP-URI".equals(attribute)) {
        System.out.println(elem.getTextContent());
    }
}