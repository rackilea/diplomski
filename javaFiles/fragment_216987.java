Node elem = nodeList.item(i);//Your Node
StringWriter buf = new StringWriter();
Transformer xform = TransformerFactory.newInstance().newTransformer();
xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes"); // optional
xform.setOutputProperty(OutputKeys.INDENT, "yes"); // optional
xform.transform(new DOMSource(elem), new StreamResult(buf));
System.out.println(buf.toString()); // your string