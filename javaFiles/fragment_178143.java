public void readXMLFile(){
    try {

    File fXmlFile = new File("highscore.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(fXmlFile);
    doc.getDocumentElement().normalize();
    System.out.println("Root element : " + doc.getDocumentElement().getNodeName());
    NodeList nList = doc.getElementsByTagName("Highscore");
    Node child = nList.item(0);
    NodeList nL = child.getChildNodes();    
    System.out.println("----------------------------");
    int i=1;
    for (int temp = 0; temp < nL.getLength(); temp++) {
        Node nNode = nL.item(temp);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;
            System.out.println(i+ ","+ eElement.getAttribute("name") +","+ eElement.getAttribute("score"));
                i++;
        }
    }
    } catch (Exception e) {
    e.printStackTrace();
    }
  }