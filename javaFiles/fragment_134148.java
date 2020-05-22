try {
  SAXBuilder builder = new SAXBuilder();
  Document anotherDocument = builder.build(new File("/some/directory/sample.xml"));
} catch(JDOMException e) {
  e.printStackTrace();
} catch(NullPointerException e) {
  e.printStackTrace();
}