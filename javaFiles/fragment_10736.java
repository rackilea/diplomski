public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File stocks = new File("PhillPlugin.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(stocks);
            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("AttributeValuePair");

            for (int i = 0; i < nodes.getLength(); i++) {
              Node node = nodes.item(i);
              if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if(i==0)
                 {
                 tempurlGen=getValue("value",element);
                   System.out.println("GenerateUrl: " + getValue("value", element));
                 }
                 else if (i==1)
                 {
                 tempurlVal=getValue("value",element);
                 System.out.println("ValidateUrl: " + getValue("value", element));
                 }

              }
            }
          }
          static String getValue(String tag, Element element) {
            NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
            Node node = (Node) nodes.item(0);
            return node.getNodeValue();
          }