public void parseXml() {
    try {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory
                .newDocumentBuilder();
        Document document = documentBuilder.parse(new InputSource(
                new ByteArrayInputStream(xml.getBytes("utf-8"))));
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("Program");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nodeItem = nodeList.item(i);
            if (nodeItem.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodeItem;

                String programNumber = ((org.w3c.dom.Element) element)
                        .getAttribute("programNumber");
                String imgUrl = ((org.w3c.dom.Element) element)
                            .getAttribute("imgUrl");
                String description = ((org.w3c.dom.Element) element)
                                .getAttribute("description");

                programsList.add(new Program(programNumber, imgUrl, description));
            }
        }
        nodeList = document.getElementsByTagName("Episode");
         for (int i = 0; i < nodeList.getLength(); i++) {   
             Node nodeItem = nodeList.item(i);
             if (nodeItem.getNodeType() == Node.ELEMENT_NODE) {
                 Element element = (Element) nodeItem;

                 String pN = ((org.w3c.dom.Element) element)
                            .getAttribute("pN");
                 String episodeNumber = ((org.w3c.dom.Element) element)
                                .getAttribute("episodeNumber");
                 String transmissionName =  ((org.w3c.dom.Element) element)
                                    .getAttribute("transmissionName");
                 String date =  ((org.w3c.dom.Element) element)
                                        .getAttribute("date");
                 String time1 = ((org.w3c.dom.Element) element)
                                            .getAttribute("time1");
                 String time2 = ((org.w3c.dom.Element) element)
                                                .getAttribute("time2");
                 String channel = ((org.w3c.dom.Element) element)
                                                    .getAttribute("channel");
                 String channelLogo = ((org.w3c.dom.Element) element)
                                                        .getAttribute("channelLogo");

                 programList.add(new Episode(pN, episodeNumber, transmissionName, date, time1, time2, channel, channelLogo));
             }
         }
    } catch (Exception e) {
        Log.d("XML", "Exception: " + e);
    }
}