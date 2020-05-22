original.getDocumentElement().normalize();
XPathExpression xpath = XPathFactory.newInstance().newXPath().compile("//text()[normalize-space(.) = '']");
NodeList blankTextNodes = (NodeList) xpath.evaluate(original, XPathConstants.NODESET);

for (int i = 0; i < blankTextNodes.getLength(); i++) {
     blankTextNodes.item(i).getParentNode().removeChild(blankTextNodes.item(i));
}