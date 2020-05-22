TransformerFactory tff = TransformerFactory.newInstance();
Transformer tf = tff.newTransformer();
// Set formatting
tf.setOutputProperty(OutputKeys.INDENT, "yes");
tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
Source sc = soapMessage.getSOAPPart().getContent();

OutputStream streamOut = new FileOutputStream(new File(changeFileFolder, "soapRequest.xml"));
StreamResult result = new StreamResult(streamOut);
tf.transform(sc, result);