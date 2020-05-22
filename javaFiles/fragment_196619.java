TransformerFactory transfac = TransformerFactory.newInstance();
 transfac.setAttribute("indent-number", 2);
 Transformer trans = transfac.newTransformer();
 trans.setOutputProperty(OutputKeys.INDENT, "yes");
 trans.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
 trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
 Result result = new StreamResult(System.out);
 trans.transform(new DomSource(document), result);