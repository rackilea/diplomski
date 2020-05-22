File file = new File("path to file");
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
        .newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    Document document = documentBuilder.parse(file);
    document.getDocumentElement().normalize();
    Element docEle = document.getDocumentElement();
    NodeList nl = docEle.getElementsByTagName("property");
    ArrayList names = new ArrayList();
    ArrayList values = new ArrayList();
    if (nl != null) {
        int length = nl.getLength();
        //System.out.println(length);
        for (int i = 0; i < length; i++) {
            if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element el = (Element) nl.item(i);
                if (el.getNodeName().contains("property")) {
                    names.add( el.getElementsByTagName("name").item(0).getTextContent());
                    //System.out.println(el.getElementsByTagName("name").item(0).getTextContent());
                    values.add( el.getElementsByTagName("value").item(0).getTextContent());
                    //System.out.println(el.getElementsByTagName("value").item(0).getTextContent());
                }
            }
        }
    }