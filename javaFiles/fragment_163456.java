String message =
        "<ns1:Prods xmlns:ns1='/foo'>"// xmlns:ns1='uri'>"
                + "<ns1:Prod>"
                + "  <ns1:ProductID>316</ns1:ProductID>"
                + "        <ns1:Name>Blade</ns1:Name>"
                + "</ns1:Prod>"
                + "<ns1:Prod>"
                + "  <ns1:ProductID>317</ns1:ProductID>"
                + " <ns1:Name>LL Crankarm</ns1:Name>"
                + "  <ns1:Color>Black</ns1:Color>"
                + "</ns1:Prod>"
                + "</ns1:Prods>";

Document doc = null;

try {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);
    dbf.setValidating(false);
    DocumentBuilder db = dbf.newDocumentBuilder();
    InputSource is = new InputSource();
    is.setCharacterStream(new StringReader(message));
    doc = db.parse(is);

    NodeList sections = doc.getElementsByTagName("ns1:Prod");
    int numSections = sections.getLength();
    for (int i = 0; i < numSections; i++) {
        Element section = (Element) sections.item(i);
        NodeList prodinfos = section.getChildNodes();
        for (int j = 0; j < prodinfos.getLength(); j++) {
            Node info = prodinfos.item(j);
            if (info.getNodeType() != Node.TEXT_NODE) {
                System.out.println(info.getNodeName() + ": " + info.getTextContent());
            }
        }
        System.out.println("");
    }
} catch (Exception e) {
    e.printStackTrace();
    doc = null;
}