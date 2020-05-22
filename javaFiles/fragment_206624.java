StringWriter sw = new StringWriter();
sw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
Transformer t = TransformerFactory.newInstance().newTransformer();

// this will work because we are creating a Java string, not writing to an output
t.setOutputProperty(OutputKeys.ENCODING, "UTF-16"); 
t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
t.transform(new DOMSource(elementNode), new StreamResult(sw));

return IOUtils.toInputStream(sw.toString(), Charset.forName("UTF-8"));