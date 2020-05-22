else if (e.getTagName().equals("bib_ref")) {
    NodeList ref = e.getChildNodes();

        for (int i = 0; i < ref.getLength(); i++) {
            Node temp = (Node) ref.item(i);

            if (temp.getNodeType() == Node.ELEMENT_NODE) {
                if (temp.getNodeType() == org.w3c.dom.Node.TEXT_NODE)
                    continue;

                 out.println(temp.getNodeName() + " : " + temp.getTextContent() + "\n");
            }
        }
}