String result = "error";
    String uri = "http://example.com/uri";
    String xpath = textArea.getText();
    ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
    try {
        Builder builder = new Builder();
        Canonicalizer canonicalizer = new Canonicalizer(bytestream, 
                Canonicalizer.EXCLUSIVE_XML_CANONICALIZATION);
        nu.xom.Document input = builder.build(xml, uri);
        Node node = input.getRootElement();
        XPathContext context = new XPathContext("a", "http://example.com/a");
        Nodes nodes = node.query(xpath, context);
        if (nodes.size() > 0) {
            canonicalizer.write(nodes.get(0));
            bytestream.close();
            result = bytestream.toString("UTF8");
        }
    catch (...){ ... }