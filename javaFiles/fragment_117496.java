NamespaceContext ctx = new ItunesNamespaceContext();

XPathFactory xpathFact = XPathFactory.newInstance();
XPath xpath = xpathFact.newXPath();
xpath.setNamespaceContext(ctx);
String IMAGE_XPATH = "//channel/itunes:image/@href";
String imageUrl = path.compile(IMAGE_XPATH).evaluate(doc,XPathConstants.STRING).toString();