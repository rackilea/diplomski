void removeDevicesWithDeactivatedStatus() throws SAXException, IOException, ParserConfigurationException, XPathExpressionException,
            TransformerException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true); // never forget this!
        Document document = dbf.newDocumentBuilder().parse(new File("input.xml"));

        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        XPathExpression expression = xpath.compile("//devices/devicesinf[status/text()='DEACTIVATED']");

        // 1) Get book titles written after 2001
        Object result = expression.evaluate(document, XPathConstants.NODESET);

        NodeList nodes = (NodeList) result;

        int numberOfDeactivatedDevices = 0;
        for (int i = 0; i < nodes.getLength(); i++) {
            numberOfDeactivatedDevices = +i;
            // System.out.println(nodes.item(i).getNodeValue() + " [" + i+"]");
            Node b13Node = (Node) expression.evaluate(document, XPathConstants.NODE);
            b13Node.getParentNode().removeChild(b13Node);

        }

        System.out.println("Deactivated devices removed: " + numberOfDeactivatedDevices);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.transform(new DOMSource(document), new StreamResult(new File("output.xml")));
        //t.transform(new DOMSource(document), new StreamResult(System.out));
}