Document doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder().parse(
                    new InputSource("test.xsd"));

    // use xpath to find node to add to
    XPath xPath = XPathFactory.newInstance().newXPath();
    NodeList nodes = (NodeList) xPath.evaluate("/schema", doc
            .getDocumentElement(), XPathConstants.NODESET);

    // create element to add
    org.w3c.dom.Element newComplexType = doc
            .createElement("xs:complexType");
    org.w3c.dom.Element newSequence = doc.createElement("xs:sequence");
    org.w3c.dom.Element newElement = doc.createElement("xs:element");
    newComplexType.setAttribute("name", "Container3");

    newElement.setAttribute("name", "element5");
    newElement.setAttribute("type", "type5");
    newElement.setAttribute("minOccurs", "0");
    newElement.setAttribute("manOccurs", "unbounded");

    nodes.item(0).appendChild(newComplexType).appendChild(newSequence)
            .appendChild(newElement);

    // output
    TransformerFactory.newInstance().newTransformer().transform(
            new DOMSource(doc.getDocumentElement()),
            new StreamResult(System.out));