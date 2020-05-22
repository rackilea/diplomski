NodeList nList = doc.getChildNodes();
        NodeList elements = nList.item(0).getChildNodes();


        for (int temp = 0; temp < elements.getLength(); temp++) {

            Node nNode = elements.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                System.out.println("Node name: " + eElement.getNodeName() + " \tValue: " + eElement.getTextContent());


            }
        }