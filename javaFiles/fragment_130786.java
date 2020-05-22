SAXBuilder builder = new SAXBuilder();
 Document document = builder.build(new File("src/com/foo/test.xml"));
 Element root = document.getRootElement();
 ElementFilter filter = new ElementFilter();
 Iterator i = root.getDescendants(filter);
 while (i.hasNext()) {
     Element element = (Element) i.next();
     System.out.println(element);
 }