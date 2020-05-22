DocumentBuilderFactory docFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(...;

        NodeList list = doc.getElementsByTagName("intercept-url");

        for (int i = 0; i < list.getLength(); i++) {
            Element node = (Element) list.item(i);
            Attr pattern = node.getAttributeNode("pattern");
            if (pattern != null && pattern.getValue().equals("/page33")) {
                node.setAttribute("access", "ROLE_ANONYM");
            }
        }

        TransformerFactory transformerFactory = TransformerFactory
                .newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(...);
        transformer.transform(source, result);