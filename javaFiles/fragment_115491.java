DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

DocumentBuilder db = dbf.newDocumentBuilder();
ByteArrayInputStream bis = new ByteArrayInputStream(
        "<A></A>".getBytes());
Document doc = db.parse(bis);

Element a = (Element) doc.getElementsByTagName("A").item(0);
Element b = (Element) doc.createElement("B");
b.setAttribute("id", "12345");
a.appendChild(b);

Transformer transformer = TransformerFactory.newInstance()
        .newTransformer();
transformer.setOutputProperty(OutputKeys.INDENT, "yes");

// initialize StreamResult with File object to save to file
StreamResult result = new StreamResult(new StringWriter());
DOMSource source = new DOMSource(doc);
transformer.transform(source, result);

String xml = result.getWriter().toString();
System.out.println(xml);