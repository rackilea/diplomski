for (int i = 0; i < nodes.getLength(); i++) {
            Node nNode = nodes.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                if (eElement.getElementsByTagName("title").item(0).getTextContent().equals(("Durst"))) {
                    nNode.removeChild(eElement.getElementsByTagName("title").item(0));
                }
            }