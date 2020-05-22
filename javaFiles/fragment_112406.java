public class DOMParser {
    private Document doc = null;
    public DOMParser() {
        try {
            doc = parserXML(new File("resource/data.xml"));

            visit(doc, 0);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void visit(Node node, int level) {
        NodeList nl = node.getChildNodes();

        for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
            if (nl.item(i).hasAttributes()) {
                printAttributes(nl.item(i));
            }

            visit(nl.item(i), level + 1);
        }
    }

    public Document parserXML(File file) throws SAXException, IOException,
            ParserConfigurationException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(file);
    }

    public static void main(String[] args) {
        new DOMParser();
    }

    private void printAttributes(Node node) {

        NamedNodeMap attrs = node.getAttributes();
        System.out.print(node.getNodeName());
        for (int i = 0; i < attrs.getLength(); i++) {
            Attr attribute = (Attr) attrs.item(i);
            System.out.print(" : " + attribute.getName() + "="
                    + attribute.getValue());
        }
        System.out.println("");
    }

}