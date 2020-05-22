char[] ch;
AttributesImpl atts = new AttributesImpl();
Writer writer = new StringWriter();
StreamResult streamResult = new StreamResult(writer);
SAXTransformerFactory tf = (SAXTransformerFactory) TransformerFactory.newInstance();

// SAX2.0 ContentHandler
TransformerHandler transformerHandler = tf.newTransformerHandler();

Transformer serializer = transformerHandler.getTransformer();

serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
// serializer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "nodes.dtd");
serializer.setOutputProperty(OutputKeys.INDENT, "yes");

transformerHandler.setResult(streamResult);

transformerHandler.startDocument();

atts.clear();
// atts.addAttribute("", "", "xmlns", "CDATA", "http://www.example.com/nodes");
// atts.addAttribute("", "", "xmlns:xsi", "CDATA", "http://www.w3.org/2001/XMLSchema-instance");
// atts.addAttribute("", "", "xsi:schemaLocation", "CDATA", "/nodes.xsd");
transformerHandler.startElement("", "", "node_list", atts);

// displayName element
if (displayName != null) {
    transformerHandler.startElement("", "", "display_name", null);
    ch = displayName.toCharArray();
    transformerHandler.characters(ch, 0, ch.length);
    transformerHandler.endElement("", "", "display_name");
}

// nodes element
transformerHandler.startElement("", "", "nodes", null);

atts.clear();
atts.addAttribute("", "", "node_type", "CDATA", "sometype");
transformerHandler.startElement("", "", "node", atts);

ch = node.getValue().toCharArray();
transformerHandler.startElement("", "", "value", null);
transformerHandler.characters(ch, 0, ch.length);
transformerHandler.endElement("", "", "value");

transformerHandler.endElement("", "", "node");

transformerHandler.endElement("", "", "nodes");

transformerHandler.endElement("", "", "node_list");

transformerHandler.endDocument();

String xml = writer.toString();