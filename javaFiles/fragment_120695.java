String xmlData = "<test><one><URL128 myAttribute='value' /></one></test>";
InputSource source = new InputSource(new StringReader(xmlData)); //or use your own input source

XPath xPath = XPathFactory.newInstance().newXPath();

NodeList list = (NodeList)xPath.evaluate("//URL128", source, XPathConstants.NODESET);
List<Element> elements = new ArrayList<Element>(list.getLength());
for (int i = 0; i < list.getLength(); i++)
{
    elements.add((Element)list.item(i));
}