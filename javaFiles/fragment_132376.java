TransformerFactory tf = TransformerFactory.newInstance();
Transformer transformer = tf.newTransformer();
DOMSource source = new DOMSource(yourDoc);
StreamResult result = new StreamResult(yourFile);
transformer.setOutputProperty(OutputKeys.INDENT, "yes");
transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
transformer.setOutputProperty(OutputKeys.INDENT, "yes");
transformer.transform(source, result);