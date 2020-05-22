XMLInputFactory inputFactory = XMLInputFactory.newInstance();
inputFactory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, false);
Transformer transformer = TransformerFactory.newInstance().newTransformer();

String xml = "my xml";
StringReader xmlReader = new StringReader(xml);
XMLEventReader eventReader = inputFactory.createXMLEventReader(xmlReader);
StAXSource source = new StAXSource(eventReader);
DOMResult result = new DOMResult();

transformer.transform(source, result);

Node document = result.getNode();