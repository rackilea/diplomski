XPath xpath = XPathFactory.newInstance().newXPath();
        XPathExpression fromAttribute = xpath.compile("@from");
        XPathExpression toAttribute = xpath.compile("@to");

        NodeList list = (NodeList) xpath.evaluate("/converter/replace/mask",
                    ((XMLConfiguration) configuration).getDocument(), XPathConstants.NODESET);

        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            String from = fromAttribute.evaluate(node);
            String to = toAttribute.evaluate(node);

            //...
        }