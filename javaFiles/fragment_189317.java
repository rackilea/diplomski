XPathExpression expr = xpath.compile("//book/validTo");
Object result = expr.evaluate(doc, XPathConstants.NODESET);
NodeList nodes = (NodeList) result;

DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
Calendar now = Calendar.getInstance();
now.set(Calendar.HOUR_OF_DAY, 0);
now.set(Calendar.MINUTE, 0);
now.set(Calendar.SECOND, 0);
now.set(Calendar.MILLISECOND, 0);

for (int i = 0; i < nodes.getLength(); i++) {
  Node validToNode = nodes.item(i);
  Date validTo = df.parse(validToNode.getTextContent());
  if (validTo.compareTo(now.getTime()) < 0) {
    Node bookNode = validToNode.getParentNode();
    removeNode(bookNode);
  }
}