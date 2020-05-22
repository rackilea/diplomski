File sourceFile = new File("Source.xml");
File customXmlFile = new File("custom.xml");

Source source = new StreamSource(sourceFile);
Result result = new StreamResult(customXmlFile);

TransformerFactory factory = TransformerFactory.newInstance();
Transformer transformer = factory.newTransformer();

transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION. "yes");
transformer.setOutputProperty(OutputKeys.INDENT. "yes");

transformer.transform(source, result);