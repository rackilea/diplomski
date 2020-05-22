StringWriter contentDataWriter = new StringWriter();
Transformer xformer = TransformerFactory.newInstance().newTransformer();
xformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
xformer.transform(new DOMSource(textContentBody),
                  new StreamResult(contentDataWriter));
String contentData = contentDataWriter.toString();