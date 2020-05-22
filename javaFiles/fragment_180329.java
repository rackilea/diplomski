string xml="<hello><hi a='a' b='b'/><hi a='b' b='a'/></hello>";

//read XML from the given string
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
InputSource is = new InputSource(new StringReader(xml));
Document doc = builder.parse(is);

//this will return a list of xml tags whose name is `hi`
NodeList hiList = document.getElementsByTagName("hi");

//you can iterate over hiList and read/process them
for (int i = 0; i < hiList.getLength(); i++) {
    Node child = hiList.item(i);
    String name = child.getNodeName();
    String contents = child.getTextContent();
}