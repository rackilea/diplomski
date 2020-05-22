public class TestXML01 {

    public static void main(String[] args) {

        String xml = "<?xml version=\"1.0\"?>";
        xml += "<root>";
        xml += "<success>true</success>";
        xml += "<note>";
        xml += "<note_id>32219</note_id>";
        xml += "<the_date>1336763490</the_date>";
        xml += "<member_id>108649</member_id>";
        xml += "<area>6</area>";
        xml += "<note>Note 123123123</note>";
        xml += "</note>";
        xml += "<note>";
        xml += "<note_id>33734</note_id>";
        xml += "<the_date>1339003652</the_date>";
        xml += "<member_id>108649</member_id>";
        xml += "<area>1</area>";
        xml += "<note>This is another note.</note>";
        xml += "</note>";
        xml += "<note>";
        xml += "<note_id>49617</note_id>";
        xml += "<the_date>1343050791</the_date>";
        xml += "<member_id>108649</member_id>";
        xml += "<area>1</area>";
        xml += "<note>this is a 3rd note.</note>";
        xml += "</note>";
        xml += "</root>";

        ByteArrayInputStream bais = null;

        try {
            bais = new ByteArrayInputStream(xml.getBytes());
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDoc = builder.parse(bais);

            Node root = xmlDoc.getDocumentElement();

            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xPath = xFactory.newXPath();

            XPathExpression xExpress = xPath.compile("/root/note");
            NodeList nodes = (NodeList) xExpress.evaluate(root, XPathConstants.NODESET);

            System.out.println("Found " + nodes.getLength() + " note nodes");

            for (int index = 0; index < nodes.getLength(); index++) {
                Node node = nodes.item(index);
                Document childDoc = builder.newDocument();
                childDoc.adoptNode(node);
                childDoc.appendChild(node);
                System.out.println(toString(childDoc));
            }

        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            try {
                bais.close();
            } catch (Exception e) {
            }
        }
    }

    public static String toString(Document doc) {

        String sValue = null;

        ByteArrayOutputStream baos = null;
        OutputStreamWriter osw = null;

        try {
            baos = new ByteArrayOutputStream();
            osw = new OutputStreamWriter(baos);

            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty(OutputKeys.METHOD, "xml");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource domSource = new DOMSource(doc);
            StreamResult sr = new StreamResult(osw);
            tf.transform(domSource, sr);

            osw.flush();
            baos.flush();
            sValue = new String(baos.toByteArray());
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            try {
                osw.close();
            } catch (Exception exp) {
            }
            try {
                baos.close();
            } catch (Exception exp) {
            }
        }
        return sValue;
    }
}