public static void main(String[] args) throws SAXException, IOException,
        ParserConfigurationException {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();

    String input = "<outer>";
    input += "<otherstuff><TaskID>123</TaskID></otherstuff>";
    input += "<flow>";
    input += "<TaskID>100</TaskID>";
    input += "<TaskID>101</TaskID>";
    input += "<TaskID>102</TaskID>";
    input += "<TaskID>103</TaskID>";
    input += "</flow>";
    input += "</outer>";
    Document document = builder.parse(new InputSource(new StringReader(
            input)));

    NodeList flowList = document.getElementsByTagName("flow");
    for (int i = 0; i < flowList.getLength(); i++) {
        NodeList childList = flowList.item(i).getChildNodes();
        for (int j = 0; j < childList.getLength(); j++) {
            Node childNode = childList.item(j);
            if ("TaskID".equals(childNode.getNodeName())) {
                System.out.println(childList.item(j).getTextContent()
                        .trim());
            }
        }
    }
}