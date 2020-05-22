Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("../Xpath/src/example.xml"));
        XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression exp = xPath.compile("//Engineer");
        NodeList nl = (NodeList)exp.evaluate(doc, XPathConstants.NODESET);
        System.out.println("Found " + nl.getLength() + " results");

        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
             StringWriter buf = new StringWriter();
                Transformer xform = TransformerFactory.newInstance().newTransformer();
                xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
                xform.transform(new DOMSource(node), new StreamResult(buf));
                System.out.println(buf.toString());
        }