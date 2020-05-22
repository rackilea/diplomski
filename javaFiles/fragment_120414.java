try {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        documentBuilderFactory.setNamespaceAware(true);
        DocumentBuilder builder = documentBuilderFactory
                .newDocumentBuilder();
        Document doc = builder.parse("path/to/xml/MyXML.xml");

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();

        XPathExpression expression = xpath
                .compile("//titles");

        NodeList nodes = (NodeList) expression.evaluate(doc,
                XPathConstants.NODESET);

        for (int i = 0; i < nodes.getLength(); i++) {
            //System.out.println(nodes.item(i).getNodeName());
            System.out.println(nodes.item(i).getTextContent());
        }
    } catch (Exception exception) {
        exception.printStackTrace();
    }