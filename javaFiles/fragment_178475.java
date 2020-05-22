/*
     * Must use a namespace aware factory
     */
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);
    Document doc = dbf.newDocumentBuilder().parse(...);


    /*
     * Create an XPath object
     */
    XPath p = XPathFactory.newInstance().newXPath();

    /*
     * Must use a namespace context
     */
    p.setNamespaceContext(new NamespaceContext() {

        public Iterator getPrefixes(String namespaceURI) {
            return null;
        }

        public String getPrefix(String namespaceURI) {
            return null;
        }

        public String getNamespaceURI(String prefix) {
            if (prefix.equals("ns1"))
                return "http://www.ibm.com/xmlns/db2/cm/beans/1.0/schema";
            if (prefix.equals("cm"))
                return "http://www.ibm.com/xmlns/db2/cm/api/1.0/schema";
            return null;
        }
    });

    /*
     * Find the ICCSFileName attribute
     */
    Node iccsFileName = (Node) p.evaluate("//ns1:ICCSPArchivSuche/@ICCFileName", doc, XPathConstants.NODE);
    System.out.println(iccsFileName.getNodeValue());

    /*
     * Find the URL
     */
    Node url = (Node) p.evaluate("//ns1:ICCSPArchivSuche/cm:resourceObject/cm:URL/@value", doc, XPathConstants.NODE);
    System.out.println(url.getNodeValue());