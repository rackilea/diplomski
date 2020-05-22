public class ParseXml {

    public static void main(String[] args) {
        System.out.println("Started XML modification");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();

            Document xmlDoc;

            xmlDoc = docBuilder.parse(new File("sample.xml"));

            NodeList nodes = xmlDoc.getElementsByTagName("fr");

            for (int i = 0, length = nodes.getLength(); i < length; i ++) {
                ((Element)nodes.item(i)).setTextContent("Modified");
            }

            xmlDoc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource domSource = new DOMSource(xmlDoc);
            StreamResult result = new StreamResult(new File("sample.xml"));
            transformer.transform(domSource, result);
            System.out.println("Modification Done");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}