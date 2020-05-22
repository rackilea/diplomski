XPathFactory xpfactory = XPathFactory.newInstance();
XPath path = xpfactory.newXPath();
try {
    String aString = path.evaluate("/branch0/name", doc);
    System.out.println(aString);
    } catch (XPathExpressionException e) { e.printStackTrace(); }