String xml = "<resp><status>good</status><msg>hi</msg></resp>";

XPathFactory xpathFactory = XPathFactory.newInstance();
XPath xpath = xpathFactory.newXPath();

InputSource source = new InputSource(new StringReader(
xml));
String status = xpath.evaluate("/resp/status", source);

System.out.println("satus=" + status);