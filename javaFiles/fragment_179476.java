try {
    NodeList childNodes = xmldoc.getDocumentElement().getChildNodes();
    for (int i = 0; i < childNodes.getLength(); i++) {
        Node node = childNodes.item(i);
        if ("InputData".equals(node.getNodeName())) {
            Node iid = node.getFirstChild();
            while (!"iid".equals(iid.getNodeName())) {
                iid = iid.getNextSibling();
            }
            String iidTree = ((DOMImplementationLS) xmldoc
                    .getImplementation()).createLSSerializer()
                    .writeToString(iid);
            System.out.println(iidTree.replaceFirst("<.*?>\n", "")
                    .replaceAll("[ ]", ""));
            break;
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}