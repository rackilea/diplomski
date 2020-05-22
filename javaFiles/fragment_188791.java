document = tidy.parseDOM(rstream, null); 

DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
Source xmlSource = new DOMSource(document);
Result outputTarget = new StreamResult(outputStream);
TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
InputStream is = new ByteArrayInputStream(outputStream.toByteArray());

Document doc = db.parse(is);