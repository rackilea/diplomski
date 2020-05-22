public static void parseXml(){
    File fXmlFile = new File("c://test.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder;
    try {
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        Element root = doc.getDocumentElement();
        NodeList childList = root.getElementsByTagName("Class");
        for (int i = 0; i<childList.getLength(); i++){
            System.out.println("Class: " + childList.item(i).getAttributes().getNamedItem("name").getNodeValue());

            NodeList attList = ((Element)childList.item(i)).getElementsByTagName("Attribute");
            for (int j = 0; j<attList.getLength(); j++){
                System.out.print("  Att: " + attList.item(j).getAttributes().getNamedItem("name").getNodeValue());
                System.out.println(" primary " + attList.item(j).getAttributes().getNamedItem("primary").getNodeValue());
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}