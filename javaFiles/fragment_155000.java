public static void main(String[] args) throws Exception {
    String xml
            = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            + "<Shapes>\n"
            + " <Shape>\n"
            + "     <ShapeType>H2</ShapeType>\n"
            + "     <Annotation>\n"
            + "         <Properties>\n"
            + "             <PropertyValue PropertyName=\"field_label\">label.modelSeriesCd</PropertyValue>\n"
            + "             <PropertyValue PropertyName=\"ContainerType\">conditionContainer</PropertyValue>\n"
            + "         </Properties>\n"
            + "     </Annotation>\n"
            + "     <FootnoteNumber>1</FootnoteNumber>\n"
            + "     <Name>label.modelSeriesCd</Name>\n"
            + "     <Rectangle>\n"
            + "         <Rectangle X=\"14\" Y=\"94\" Width=\"43\" Height=\"12\" />\n"
            + "     </Rectangle>\n"
            + " </Shape>\n"
            + " <Shape>\n"
            + "     <ShapeType>H2</ShapeType>\n"
            + "     <Annotation>\n"
            + "         <Properties>\n"
            + "             <PropertyValue PropertyName=\"field_label\">label.modelSeriesMd</PropertyValue>\n"
            + "             <PropertyValue PropertyName=\"ContainerType\">mContainer</PropertyValue>\n"
            + "         </Properties>\n"
            + "     </Annotation>\n"
            + "     <FootnoteNumber>1</FootnoteNumber>\n"
            + "     <Name>label.modelSeriesCd</Name>\n"
            + "     <Rectangle>\n"
            + "         <Rectangle X=\"14\" Y=\"94\" Width=\"43\" Height=\"12\" />\n"
            + "     </Rectangle>\n"
            + " </Shape>\n"
            + "</Shapes>";

    Document xmlDocument = DocumentBuilderFactory
            .newInstance()
            .newDocumentBuilder()
            .parse(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));

    Node node = findPropertyTagAndValue(xmlDocument.getFirstChild(), "PropertyValue", "conditionContainer");
    if (node != null) {
        System.out.println("Node Name = " + node.getNodeName() + "; Value = " + node.getTextContent());
    }
}

public static Node findPropertyTagAndValue(Node node, String propertyTag, String propertyValue) {
    if (node == null) {
        // The node we're looking for does not exist
        return null;
    } else if (node.getNodeType() != Node.ELEMENT_NODE) {
        // Move to the next sibling node
        return findPropertyTagAndValue(node.getNextSibling(), propertyTag, propertyValue);
    } else if (node.getNodeName().equalsIgnoreCase(propertyTag) && node.getTextContent().equalsIgnoreCase(propertyValue)) {
        // We found the node we are looking for
        return node;
    } else if (node.hasChildNodes()) {
        // Check into the child nodes
        Node childNode = findPropertyTagAndValue(node.getFirstChild(), propertyTag, propertyValue);
        if (childNode == null) {
            // Nothing found in child node, so move to next sibling
            childNode = findPropertyTagAndValue(node.getNextSibling(), propertyTag, propertyValue);
        }
        return childNode;
    } else {
        // Move to the next sibling
        return findPropertyTagAndValue(node.getNextSibling(), propertyTag, propertyValue);
    }
}