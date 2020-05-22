public static void main(String[] args) {
    try {
        URL url = new URL("http://www.aboutsports.co.uk/fixtures/");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(url.openStream());

        NodeList list = doc.getElementsByTagName("item"); // get <item> nodes

        for (int i = 0; i < list.getLength(); i++) {
            Node item = list.item(i);
            NodeList descriptions = ((Element)item).getElementsByTagName("description"); // get <description> nodes within an <item>
            for (int j = 0; j < descriptions.getLength(); j++) {
                Node description = descriptions.item(0);

                System.out.println(description.getTextContent()); // print the text content
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}