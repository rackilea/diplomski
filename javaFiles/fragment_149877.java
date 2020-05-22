NodeList nodeList = doc.getElementsByTagName("exist:resource");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node n = nodeList.item(i);
            Node actualNode = n.getFirstChild();
            if (actualNode != null) {
                // Will return node value
                System.out.println(actualNode.getNodeValue());
                // Will return the attribute value
                System.out.println(current.getAttributeValue("name")); 
            }
        }