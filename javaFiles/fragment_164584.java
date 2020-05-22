DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);

    DocumentBuilder db = dbf.newDocumentBuilder();

    Document doc = db.newDocument();

    String ns1 = "http://example.com/ns1";
    String ns2 = "http://example.com/ns2";

    Element root = doc.createElementNS(ns1, "pf1:root");
    root.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:pf2", ns2);

    doc.appendChild(root);

    Element foo = doc.createElementNS(ns1, "pf1:foo");
    foo.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:pf1", ns1);
    foo.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:pf2", ns2);
    root.appendChild(foo);

    DOMImplementationLS  domImp = (DOMImplementationLS)doc.getImplementation();

    LSSerializer ser = domImp.createLSSerializer();

    System.out.println(ser.writeToString(doc));