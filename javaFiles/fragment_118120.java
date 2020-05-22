ClassLoader loader = XmlTestReader.class.getClassLoader();
InputStream inputStream = loader.getResourceAsStream("test.xml");
InputSource inputSource = new InputSource(inputStream);

XPathFactory xPathFactory = XPathFactory.newInstance();
XPath xPath = xPathFactory.newXPath();
XPathExpression expr = xPath.compile("/Main/Port[@name='write_qwe']/output/return/@code");
NodeList nl = (NodeList) expr.evaluate(inputSource , XPathConstants.NODESET);