public class XmlFileReader{
    public NodeList readXML(String filePath, String tagName, String subTagName, String tagAttr) {
        try {
            // Get XML file object.
            File fXmlFile = new File(filePath);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nodeList = doc.getElementsByTagName(tagName);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    if (element.getAttribute("name").equalsIgnoreCase(tagAttr)) {
                        NodeList elementsByTagName = element.getElementsByTagName(subTagName);
                        return elementsByTagName ;
                    }
                }
            }
        } catch (Exception e) {
            StringWriter stack = new StringWriter();
            e.printStackTrace(new PrintWriter(stack));
            LogManager.fatal(stack.toString(), ReadTemplate.class.getName());
        }
        return elementsByTagName;
    }
}