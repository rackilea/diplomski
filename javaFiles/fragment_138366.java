String xml = "<root xmlns=\"http://www.myschema.org\">\n" +
             "<text>This is text</text>\n" +
             "<number>32</number>\n" +
             "<number>abc</number>\n" +
             "</root>";

DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setNamespaceAware(true);
Document doc = dbf.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
Schema schema = getSchema(getClass().getResource("myschema.xsd"));

Validator validator = schema.newValidator();
try
{
    validator.validate(new DOMSource(doc));
}
catch (SAXParseException e)
{
    Element curElement = (Element)validator.getProperty("http://apache.org/xml/properties/dom/current-element-node");

    System.out.println("Validation error: " + e.getMessage());
    System.out.println(curElement.getLocalName() + ": " + curElement.getTextContent());

    //Use curElement.getParentNode() or whatever you need here
}