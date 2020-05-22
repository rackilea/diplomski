DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
factory.setNamespaceAware(true);
DocumentBuilder builder = factory.newDocumentBuilder();  
Document document = builder.parse( new InputSource(new StringReader(...)));

XPath xpath = XPathFactory.newInstance().newXPath();
xpath.setNamespaceContext(new MyNamespaceContext());
String s = xpath.evaluate("//location:address/text()", document);
System.out.println(s2);