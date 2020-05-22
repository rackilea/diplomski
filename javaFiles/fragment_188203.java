// -------------- building the document out of the file  -----------------
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
Document document = dbf.newDocumentBuilder().parse(new File("input.xml"));
//------------------------------------------------------------------------

// -------------- finding the right node and removing it -----------------
Element table = document.getDocumentElement();
Node row3 = table.getElementsByTagName("row3").item(0);
table.removeChild(row3);
//------------------------------------------------------------------------

// -------------- printing the resulting tree to the console -------------
TransformerFactory tf = TransformerFactory.newInstance();
Transformer t = tf.newTransformer();
t.transform(new DOMSource(document), new StreamResult(System.out));
//------------------------------------------------------------------------