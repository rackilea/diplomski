try {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(XMLstring));
        Document doc = db.parse(is);

        NodeList nodes = doc.getElementsByTagName("client-details");
        Node node = nodes.item(0);

        NodeList client_details = node.getChildNodes();

        Element elementary;

        for (int i = 0; i < client_details.getLength(); i++) {
            if(client_details.item(i).getNodeType() == Node.ELEMENT_NODE) {
                elementary = (Element) client_details.item(i);

                System.out.println(elementary.getTagName()+" = "+getTextContents(client_details.item(i)));
            }
        }
    }