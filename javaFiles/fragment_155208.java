void someMethodName(Document doc, String selector) {
  Elements partOne = doc.select(selector);
  for (Element element : partOne) {
    String myElementOne = element.attr("abs:href");
    System.out.println(myElementOne);
  }
}