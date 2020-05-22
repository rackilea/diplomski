public static void main(String[] args) throws Exception {
    final String xml = "<wrapper>\n"
            + "    <metadata>\n"
            + "        <somefield>somevalue</somefield>\n"
            + "        <anotherfield>othervalue</anotherfield>\n"
            + "    </metadata>\n"
            + "    <data>\n"
            + "        <some>\n"
            + "            <unique>\n"
            + "                <xml>\n"
            + "                    <structure>stuff</structure>\n"
            + "                </xml>\n"
            + "            </unique>\n"
            + "        </some>\n"
            + "    </data>\n"
            + "</wrapper>";
    final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes(Charsets.UTF_8)));
    final XPathExpression xpath = XPathFactory.newInstance().newXPath().compile("//some");
    final Node node = (Node) xpath.evaluate(doc, XPathConstants.NODE);
    StringWriter sw = new StringWriter();
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
    transformer.transform(new DOMSource(node), new StreamResult(sw));
    System.out.println(sw.toString());
}