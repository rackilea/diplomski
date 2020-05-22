DOMSource source = new DOMSource(document);
ByteArrayOutputStream outStream = new ByteArrayOutputStream();
StreamResult result = new StreamResult(outStream);
transformer.transform(source, result);
String resultString = new String( outStream.toByteArray());
System.out.println(resultString);