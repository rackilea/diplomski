public static void main(String argv[]) throws Exception {
    File fXmlFile = new File("c://file.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(fXmlFile);
    doc.getDocumentElement().normalize();
    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
    NodeList nList = doc.getElementsByTagName("passenger");
    System.out.println("-----------------------");
    for (int temp = 0; temp < nList.getLength(); temp++) {
        Node nNode = nList.item(temp);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println("Passenger id : " + e.getAttribute("id"));
            System.out.println("Name : " + e.getElementsByTagName("name").item(0).getTextContent());
        }
    }
}