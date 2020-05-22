TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
Transformer transformer = transformerFactory.newTransformer(new StreamSource("sample.xsl"));
transformer.setOutputProperty(OutputKeys.INDENT, "yes");
transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
DOMSource domSource = new DOMSource(xmlDoc);
StreamResult result = new StreamResult(new File("sample.xml"));
transformer.transform(domSource, result);