import javax.xml.xpath.*;

class Extract {
    public static void main(String[] args) {

        try {
            File fXmlFile = new File("data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            XPath xpath = XPathFactory.newInstance().newXPath();
            NodeList nodes = (NodeList)xpath.evaluate("/TXNEXP/*/PAN", doc, XPathConstants.NODESET);
            for (int n = 0; n < nodes.getLength(); n++) {
                System.out.println(nodes.item(n).getFirstChild().getNodeValue());
                if (n == 1) {
                    nodes.item(n).getFirstChild().setNodeValue("4567");
                    System.out.println(nodes.item(n).getFirstChild().getNodeValue());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}