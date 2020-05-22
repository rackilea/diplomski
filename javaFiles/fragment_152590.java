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

                Program program = new Program();

                program.setProgramNumber(((org.w3c.dom.Element) element)
                        .getAttribute("programNumber"));
                program.setImgUrl(((org.w3c.dom.Element) element)
                        .getAttribute("imgUrl"));
                program.setDescription(((org.w3c.dom.Element) element)
                        .getAttribute("description"));

                programsList.add(program);
            }
        }
        nodeList = document.getElementsByTagName("Episode");
         for (int i = 0; i < nodeList.getLength(); i++) {   
             Node nodeItem = nodeList.item(i);
             if (nodeItem.getNodeType() == Node.ELEMENT_NODE) {
                 Element element = (Element) nodeItem;

                 Episode episode = new Episode(); //creating new episode object

                 episode.setpN(((org.w3c.dom.Element) element)
                            .getAttribute("pN"));
                 episode.setEpisodeNumber(((org.w3c.dom.Element) element)
                        .getAttribute("episodeNumber"));
                 episode.setTransmissionName(((org.w3c.dom.Element) element)
                        .getAttribute("transmissionName"));
                 episode.setDate(((org.w3c.dom.Element) element)
                        .getAttribute("date"));
                 episode.setTime1(((org.w3c.dom.Element) element)
                        .getAttribute("time1"));
                 episode.setTime2(((org.w3c.dom.Element) element)
                        .getAttribute("time2"));
                 episode.setChannel(((org.w3c.dom.Element) element)
                        .getAttribute("channel"));
                 episode.setChannelLogo(((org.w3c.dom.Element) element)
                        .getAttribute("channelLogo"));

                 programList.add(episode);
             }
         }
    } catch (Exception e) {
        Log.d("XML", "Exception: " + e);
    }
}