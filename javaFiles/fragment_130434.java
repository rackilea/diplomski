String xPathExpression = "*/person/name[firstname/text() = 'Helmut' and familyname/text() = 'sperling']";
    XPath path = XPathFactory.newInstance().newXPath();
    NodeList nl = (NodeList) path.evaluate(xPathExpression, doc, XPathConstants.NODESET);
    for (int i = 0; i < nl.getLength(); i++) {
        Element childElement = doc.createElement("title");
        childElement.appendChild(doc.createTextNode("Dr."));
        nl.item(i).insertBefore(childElement,((Element)nl.item(i)).getFirstChild());
    }