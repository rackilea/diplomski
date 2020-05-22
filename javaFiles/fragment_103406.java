private Document getDocument() {
        Document d = null;
        try {
           FileInputStream  f = openFileInput(xmlFileName);

           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           d = dBuilder.parse(f);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 

        return  d;
    }