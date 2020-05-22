Object result = expr.evaluate(doc, XPathConstants.NODESET);
NodeList nodes = (NodeList) result;
for (int i = 0; i < nodes.getLength(); i++)
{
    Node currentItem = nodes.item(i);
    String key = currentItem.getAttributes().getNamedItem("key").getNodeValue();
    String value = currentItem.getTextContent();

    System.out.printf("%1s = %2s\n", key, value);
}