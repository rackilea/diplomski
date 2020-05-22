NodeList listNode = doc.getElementsByTagName("node");

    for (int temp2 = 0; temp2 < listNode.getLength(); temp2++) {

        Node node = listNode.item(temp2);

        System.out.println("\nCurrent Element :" + node.getNodeName());

        if (node.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) node;

            System.out.println("Node id : " + eElement.getAttribute("id"));

        }
    }