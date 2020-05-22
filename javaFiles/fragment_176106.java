String url = "http://stackoverflow.com/questions/3152138";
Document document = new Tidy().parseDOM(new URL(url).openStream(), null);
XPath xpath = XPathFactory.newInstance().newXPath();

Node question = (Node) xpath.compile("//*[@id='question']//*[contains(@class,'post-text')]//p[1]").evaluate(document, XPathConstants.NODE);
System.out.println("Question: " + question.getFirstChild().getNodeValue());

NodeList answerers = (NodeList) xpath.compile("//*[@id='answers']//*[contains(@class,'user-details')]//a[1]").evaluate(document, XPathConstants.NODESET);
for (int i = 0; i < answerers.getLength(); i++) {
    System.out.println("Answerer: " + answerers.item(i).getFirstChild().getNodeValue());
}