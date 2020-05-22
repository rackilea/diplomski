// Keep only entries that have both email and callname
String expr = "/dsml/entries/entry[att[@name = 'email'] and att[@name = 'callname']]/att[@name = 'email' or @name = 'callname']/value";
NodeList nl = (NodeList) xPath.evaluate(expr, doc, XPathConstants.NODESET);

Map<String, String> map = new HashMap<>();
for (int i=0; i< nl.getLength(); i++){
    Node node = nl.item(i);
    String name, email;
    // Check whether the current value is the value of the email or callname
    if ("callnamen".equals(node.getParentNode().getAttributes().getNamedItem("name").getTextContent())) {
        name = node.getTextContent();
        email = nl.item(++i).getTextContent();
    } else {
        name = nl.item(++i).getTextContent();
        email = node.getTextContent();
    }
    map.put(name, email);
}
System.out.println(map);