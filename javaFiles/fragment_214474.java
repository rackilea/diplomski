public static void main(String argv[]) throws ParserConfigurationException, IOException, SAXException {

        //Read xml file
        File fXmlFile = new File("/test.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        //Get usine nodes
        NodeList nodeList = doc.getElementsByTagName("usine");

        //Iterate nodeList
        for (int temp = 0; temp < nodeList.getLength(); temp++) {

            //Get each node and process it
            Node node = nodeList.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                //Print attributes of the node
                Element element = (Element) node;
                System.out.println("X = " + element.getAttribute("x"));
                System.out.println("Y = " + element.getAttribute("y"));
                System.out.println("ID = " + element.getAttribute("id"));

            }
        }
    }