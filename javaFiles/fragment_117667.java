File fXmlFile = new File("MapClick.php.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(fXmlFile);

    Element rootElement = doc.getDocumentElement();

    NodeList nodeList = rootElement.getElementsByTagName("layout-key");
    int size = nodeList.getLength();

    for (int i = 0; i < size; i++) {
        Node currentNode = nodeList.item(i);

        if (currentNode.getTextContent().trim().equals("k-p12h-n14-1")) {
            while (currentNode.getNextSibling() != null) {
                currentNode = currentNode.getNextSibling();

                if (currentNode.getNodeName().equals("start-valid-time")) {
                    System.out.println(((Element)currentNode).getAttribute("period-name"));
                }
            }
        }
    }