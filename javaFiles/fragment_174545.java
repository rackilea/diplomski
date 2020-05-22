NodeList nList = doc.getElementsByTagName("document");
    for (int i = 0; i < nList.getLength(); i++) {
        Node nNode = nList.item(i);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;
            NodeList fieldNodes = eElement.getElementsByTagName("field");
            for(int j = 0; j < fieldNodes.getLength(); j++) {
                Node fieldNode = fieldNodes.item(j);
                NamedNodeMap attributes = fieldNode.getAttributes();
                Node attr = attributes.getNamedItem("name");
                if(attr != null) {
                    if(attr.getTextContent().equals("Test/Content/Modified")) {
                        Date date = new Date(fieldNode.getTextContent());
                        System.out.println(date);
                        Date date1 = new Date(2014 - 1900, 06 - 1, 04);
                        if (date.compareTo(date1) == 1) {
                            list.add(eElement.getAttribute("path").trim());
                        }
                    }
                }
            }
        }
    }