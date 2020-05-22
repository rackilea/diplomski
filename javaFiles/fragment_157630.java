TransformerFactory tFactory =  TransformerFactory.newInstance();
Transformer transformer = tFactory.newTransformer();
DOMSource domSource = new DOMSource(document);
//to print the string in sysout, System.out
StreamResult streamResult = new StreamResult(System.out);
transformer.transform(domSource, streamResult );